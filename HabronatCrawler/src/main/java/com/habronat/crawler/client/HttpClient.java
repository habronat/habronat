package com.habronat.crawler.client;

import java.io.IOException;

public interface HttpClient {

    Response get(String url) throws IOException;

    Response post(String url) throws IOException;
}
