package em.external.reservationsapi;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.evomaster.client.java.controller.ExternalSutController;
import org.evomaster.client.java.controller.InstrumentedSutStarter;
import org.evomaster.client.java.controller.api.dto.AuthenticationDto;
import org.evomaster.client.java.controller.api.dto.JsonTokenPostLoginDto;
import org.evomaster.client.java.controller.api.dto.SutInfoDto;
import org.evomaster.client.java.sql.DbSpecification;
import org.evomaster.client.java.controller.problem.ProblemInfo;
import org.evomaster.client.java.controller.problem.RestProblem;
import org.testcontainers.containers.GenericContainer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExternalEvoMasterController extends ExternalSutController {


    public static void main(String[] args) {

        int controllerPort = 40100;
        if (args.length > 0) {
            controllerPort = Integer.parseInt(args[0]);
        }
        int sutPort = 12345;
        if (args.length > 1) {
            sutPort = Integer.parseInt(args[1]);
        }
        String jarLocation = "cs/rest/reservations-api/build/libs";
        if (args.length > 2) {
            jarLocation = args[2];
        }
        if(! jarLocation.endsWith(".jar")) {
            jarLocation += "/reservations-api-sut.jar";
        }

        int timeoutSeconds = 120;
        if(args.length > 3){
            timeoutSeconds = Integer.parseInt(args[3]);
        }
        String command = "java";
        if(args.length > 4){
            command = args[4];
        }


        ExternalEvoMasterController controller =
                new ExternalEvoMasterController(controllerPort, jarLocation,
                        sutPort, timeoutSeconds, command);
        InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);

        starter.start();
    }

    private final int timeoutSeconds;
    private final int sutPort;
    private  String jarLocation;
    private static final int MONGODB_PORT = 27017;

    //https://www.mongodb.com/docs/drivers/java/sync/current/compatibility/
    private static final String MONGODB_VERSION = "4.4";

    private static final String MONGODB_DATABASE_NAME = "reservations-api";

    private static final GenericContainer mongodbContainer = new GenericContainer("bitnami/mongodb:" + MONGODB_VERSION)
            .withTmpFs(Collections.singletonMap("/bitnami/mongodb", "rw"))
            .withEnv("MONGODB_REPLICA_SET_MODE", "primary")
            .withEnv("ALLOW_EMPTY_PASSWORD", "yes")
            .withExposedPorts(MONGODB_PORT);

    private static final String rawPassword = "bar123";
    private static final String hashedPassword = "$2a$10$nEDY5j731yXGnQHyM39PWurJWr1FukegmKYYarK5WOoAMmgDs6D3u";

    private String mongoDbUrl;

    private MongoClient mongoClient;


    public ExternalEvoMasterController(){
        this(40100, "../core/target", 12345, 120, "java");
    }

    public ExternalEvoMasterController(String jarLocation) {
        this();
        this.jarLocation = jarLocation;
    }

    public ExternalEvoMasterController(
            int controllerPort, String jarLocation, int sutPort, int timeoutSeconds, String command
           ) {

        if(jarLocation==null || jarLocation.isEmpty()){
            throw new IllegalArgumentException("Missing jar location");
        }


        this.sutPort = sutPort;
        this.jarLocation = jarLocation;
        this.timeoutSeconds = timeoutSeconds;
        setControllerPort(controllerPort);
        setJavaCommand(command);
    }


    @Override
    public String[] getInputParameters() {
        return new String[]{
                "--server.port=" + sutPort,
                "--databaseUrl="+mongoDbUrl,
                "--spring.data.mongodb.uri="+mongoDbUrl,
                "--app.jwt.secret=abcdef012345678901234567890123456789abcdef012345678901234567890123456789"
        };
    }

    public String[] getJVMParameters() {
        return new String[]{};
    }

    @Override
    public String getBaseURL() {
        return "http://localhost:" + sutPort;
    }

    @Override
    public String getPathToExecutableJar() {
        return jarLocation;
    }

    @Override
    public String getLogMessageOfInitializedServer() {
        return "Started ReservationsApi in";
    }

    @Override
    public long getMaxAwaitForInitializationInSeconds() {
        return timeoutSeconds;
    }

    @Override
    public void preStart() {
        mongodbContainer.start();
        mongoDbUrl = "mongodb://" + mongodbContainer.getContainerIpAddress() + ":" + mongodbContainer.getMappedPort(MONGODB_PORT) + "/" + MONGODB_DATABASE_NAME;
        mongoClient = MongoClients.create(mongoDbUrl);
    }

    @Override
    public void postStart() {
    }

    @Override
    public void resetStateOfSUT() {
        mongoClient.getDatabase(MONGODB_DATABASE_NAME).drop();

        mongoClient.getDatabase(MONGODB_DATABASE_NAME).createCollection("users");

        MongoCollection<Document> users = mongoClient.getDatabase(MONGODB_DATABASE_NAME).getCollection("users");
        users.insertMany(Arrays.asList(
                new Document()
                        .append("_id", new ObjectId())
                        .append("_class", "sk.cyrilgavala.reservationsApi.model.User")
                        .append("username", "foo")
                        .append("email", "foo@foo.com")
                        .append("password", hashedPassword)
                        .append("role", "USER"),
                new Document()
                        .append("_id", new ObjectId())
                        .append("_class", "sk.cyrilgavala.reservationsApi.model.User")
                        .append("username", "bar")
                        .append("email", "bar@foo.com")
                        .append("password", hashedPassword)
                        .append("role", "USER"),
                new Document()
                        .append("_id", new ObjectId())
                        .append("_class", "sk.cyrilgavala.reservationsApi.model.User")
                        .append("username", "admin")
                        .append("email", "admin@foo.com")
                        .append("password", hashedPassword)
                        .append("role", "ADMIN")
        ));

    }

    @Override
    public void preStop() {
    }

    @Override
    public void postStop() {
        mongodbContainer.stop();
    }



    @Override
    public String getPackagePrefixesToCover() {
        return "sk.cyrilgavala.reservationsApi.";
    }

    @Override
    public ProblemInfo getProblemInfo() {
        return new RestProblem(
                "http://localhost:" + sutPort + "/v3/api-docs",
                null
        );
    }

    @Override
    public SutInfoDto.OutputFormat getPreferredOutputFormat() {
        return SutInfoDto.OutputFormat.JAVA_JUNIT_5;
    }



    @Override
    public List<AuthenticationDto> getInfoForAuthentication() {

        return Arrays.asList(
                new AuthenticationDto() {{
                    name = "admin";
                    jsonTokenPostLogin = new JsonTokenPostLoginDto() {{
                        userId = "admin";
                        endpoint = "/api/user/login";
                        jsonPayload = "{\"username\":\"admin\", \"password\":\""+rawPassword+"\"}";
                        extractTokenField = "/accessToken";
                        headerPrefix = "Bearer ";
                    }};
                }},
                new AuthenticationDto() {{
                    name = "foo";
                    jsonTokenPostLogin = new JsonTokenPostLoginDto() {{
                        userId = "foo";
                        endpoint = "/api/user/login";
                        jsonPayload = "{\"username\":\"foo\", \"password\":\""+rawPassword+"\"}";
                        extractTokenField = "/accessToken";
                        headerPrefix = "Bearer ";
                    }};
                }},
                new AuthenticationDto() {{
                    name = "bar";
                    jsonTokenPostLogin = new JsonTokenPostLoginDto() {{
                        userId = "bar";
                        endpoint = "/api/user/login";
                        jsonPayload = "{\"username\":\"bar\", \"password\":\""+rawPassword+"\"}";
                        extractTokenField = "/accessToken";
                        headerPrefix = "Bearer ";
                    }};
                }}
        );
    }

    @Override
    public List<DbSpecification> getDbSpecifications() {
        return null;
    }

    @Override
    public Object getMongoConnection() {
        return mongoClient;
    }
}
