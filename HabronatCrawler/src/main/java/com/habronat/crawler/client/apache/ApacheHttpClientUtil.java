package com.habronat.crawler.client.apache;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class ApacheHttpClientUtil {

    private static final String EMPTY_CONTENT = "";
    private static final Logger logger = LoggerFactory.getLogger(ApacheHttpClientUtil.class);

    public static String getContent(HttpResponse response) {
        try {
            return IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset());
        } catch (IOException e) {
            int statusCode = response.getStatusLine().getStatusCode();
            logger.error(String.format("Failed to retrieve content from HTTP response. Response status code: %s", statusCode), e);
            return EMPTY_CONTENT;
        }
    }
}
