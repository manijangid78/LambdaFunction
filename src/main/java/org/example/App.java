package org.example;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Map;

public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        Map<String, String> queryParams = apiGatewayProxyRequestEvent.getQueryStringParameters();
        Map<String, String> pathParam = apiGatewayProxyRequestEvent.getPathParameters();
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

        responseEvent.setBody("body text"+queryParams.get("name")+pathParam.get("id"));
        responseEvent.setStatusCode(200);
        return responseEvent;
    }
}
