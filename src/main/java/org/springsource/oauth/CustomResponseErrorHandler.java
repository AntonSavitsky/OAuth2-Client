package org.springsource.oauth;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomResponseErrorHandler implements ResponseErrorHandler {

    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return errorHandler.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        String theString = IOUtils.toString(response.getBody());
        Map<String, Object> properties = new HashMap<String, Object>();

        properties.put("code", response.getStatusCode().toString());
        properties.put("body", theString);
        properties.put("header", response.getHeaders());

        System.out.println("code: "+response.getStatusCode().toString());
        System.out.println("body: "+theString);
        System.out.println("header: "+response.getHeaders());
    }
}