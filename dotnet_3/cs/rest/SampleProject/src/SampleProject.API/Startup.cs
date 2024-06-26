﻿using System;
using System.Linq;
using Hellang.Middleware.ProblemDetails;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Caching.Memory;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Configuration.UserSecrets;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using SampleProject.API.Configuration;
using SampleProject.Application.Configuration.Validation;
using SampleProject.API.SeedWork;
using SampleProject.Application.Configuration;
using SampleProject.Application.Configuration.Emails;
using SampleProject.Domain.SeedWork;
using SampleProject.Infrastructure;
using SampleProject.Infrastructure.Caching;
using Serilog;
using Serilog.Formatting.Compact;
using Microsoft.OpenApi.Models;
using SampleProject.Infrastructure.Database;

[assembly: UserSecretsId("54e8eb06-aaa1-4fff-9f05-3ced1cb623c2")]

namespace SampleProject.API
{
    public class Startup
    {
        private readonly IConfiguration _configuration;

        private const string OrdersConnectionString = "OrdersConnectionString";

        private static ILogger _logger;

        public Startup(IWebHostEnvironment env, IConfiguration configuration)
        {
            _configuration = configuration;
            _logger = ConfigureLogger();
            _logger.Information("Logger configured");
            
            // this._configuration = new ConfigurationBuilder()
            //     .AddJsonFile("appsettings.json")
            //     .AddJsonFile($"appsettings.{env.EnvironmentName}.json")
            //     .AddJsonFile($"hosting.{env.EnvironmentName}.json")
            //     .AddUserSecrets<Startup>()
            //     .Build();
        }

        public IServiceProvider ConfigureServices(IServiceCollection services)
        {
            //read connection string from the driver, if null, then from the appsettings of the SUT
            var connectionString = _configuration.GetValue<string>("ConnectionStringFromDriver") ?? _configuration.GetConnectionString(OrdersConnectionString);

            services.AddControllers();
    
            services.AddMemoryCache();

            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new OpenApiInfo {Title = "Sample API", Version = "v1"});
            });

            services.AddProblemDetails(x =>
            {
                x.Map<InvalidCommandException>(ex => new InvalidCommandProblemDetails(ex));
                x.Map<BusinessRuleValidationException>(ex => new BusinessRuleValidationExceptionProblemDetails(ex));
            });


            services.AddHttpContextAccessor();
            var serviceProvider = services.BuildServiceProvider();

            IExecutionContextAccessor executionContextAccessor =
                new ExecutionContextAccessor(serviceProvider.GetService<IHttpContextAccessor>());

            var children = this._configuration.GetSection("Caching").GetChildren();
            var cachingConfiguration = children.ToDictionary(child => child.Key, child => TimeSpan.Parse(child.Value));
            var emailsSettings = _configuration.GetSection("EmailsSettings").Get<EmailsSettings>();
            var memoryCache = serviceProvider.GetService<IMemoryCache>();
            
                       
            return ApplicationStartup.Initialize(
                services,
                connectionString,
                new MemoryCacheStore(memoryCache, cachingConfiguration),
                null,
                emailsSettings,
                _logger,
                executionContextAccessor);
        }

        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
             CreateDatabase(app);
            
            app.UseMiddleware<CorrelationMiddleware>();

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseProblemDetails();
            }

            app.UseRouting();

            app.UseSwagger();
            app.UseSwaggerUI(c => { c.SwaggerEndpoint("/swagger/v1/swagger.json", "Sample API"); });

            app.UseEndpoints(endpoints => { endpoints.MapControllers(); });
        }

        private static ILogger ConfigureLogger()
        {
            return new LoggerConfiguration()
                .Enrich.FromLogContext()
                .WriteTo.Console(
                    outputTemplate: "[{Timestamp:HH:mm:ss} {Level:u3}] [{Context}] {Message:lj}{NewLine}{Exception}")
                .WriteTo.RollingFile(new CompactJsonFormatter(), "logs/logs")
                .CreateLogger();
        }

        private static void CreateDatabase(IApplicationBuilder app)
        {
            using (var serviceScope = app.ApplicationServices.GetService<IServiceScopeFactory>()?.CreateScope())
            {
                if (serviceScope == null) return;

                var context = serviceScope.ServiceProvider.GetRequiredService<OrdersContext>();

                context.Database.EnsureCreated();

                var serviceProvider = serviceScope.ServiceProvider;
            }
        }
    }
}