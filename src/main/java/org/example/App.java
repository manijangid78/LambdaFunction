package org.example;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.User;

import java.util.Map;

public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        Map<String, String> queryParams = apiGatewayProxyRequestEvent.getQueryStringParameters();
        Map<String, String> pathParam = apiGatewayProxyRequestEvent.getPathParameters();
        String body = apiGatewayProxyRequestEvent.getBody();

        ObjectMapper mapper = new ObjectMapper();
        User user=null;
        try {
            user = mapper.readValue(body, User.class);
        } catch (JsonProcessingException e) {
            APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
            responseEvent.setBody("Exception :" + e.toString());
            responseEvent.setStatusCode(500);
            return responseEvent;
        }

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setBody("body text"+queryParams.get("name")+pathParam.get("id")+ user.toString());
        responseEvent.setStatusCode(200);
        return responseEvent;
    }
}
