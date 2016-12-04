package com.habronat.crawler.client.apache;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApacheHttpClientFactory {

    public HttpClient get() {
        return HttpClientBuilder.create().build();
    }
}
