package org.devgateway.utils;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

public class MockMvcLoggingUtils {

    public static void logRequestAndResponse(WebApplicationContext wac, MockHttpServletRequestBuilder requestBuilder, MvcResult mvcResult) throws Exception {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(requestBuilder.buildRequest(wac.getServletContext()));
        MockHttpServletResponse response = mvcResult.getResponse();

        wrappedRequest.getParameterMap();

        System.out.println("Request URI: " + wrappedRequest.getRequestURI());
        System.out.println("Request Method: " + wrappedRequest.getMethod());
        System.out.println("Request Headers: ");
        Enumeration<String> headerNames = wrappedRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + wrappedRequest.getHeader(headerName));
        }
        System.out.println("Request Parameters: " + wrappedRequest.getParameterMap());
        System.out.println("Request Body: " + new String(wrappedRequest.getContentAsByteArray(), StandardCharsets.UTF_8));

        System.out.println("Response Status: " + response.getStatus());
        System.out.println("Response Body: " + response.getContentAsString());
    }
}