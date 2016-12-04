package com.habronat.crawler.client;

import com.habronat.crawler.client.apache.ApacheHttpClientFactory;
import com.habronat.crawler.client.apache.ApacheHttpClientUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpClientImpl implements HttpClient {

    private final ApacheHttpClientFactory apacheHttpClientFactory;

    @Autowired
    public HttpClientImpl(ApacheHttpClientFactory apacheHttpClientFactory) {
        this.apacheHttpClientFactory = apacheHttpClientFactory;
    }

    @Override
    public Response get(String url) throws IOException {
        HttpGet getRequest = new HttpGet(url);
        return execute(getRequest);
    }

    @Override
    public Response post(String url) throws IOException {
        HttpPost postRequest = new HttpPost(url);
        return execute(postRequest);
    }

    private Response execute(HttpUriRequest request) throws IOException {
        HttpResponse response = apacheHttpClientFactory.get().execute(request);
        String responseContent = ApacheHttpClientUtil.getContent(response);
        return new Response(responseContent);
    }
}
