package com.habronat.crawler.client.apache;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.SecureRandom;

@Component
public class ApacheHttpClientFactory {
    private final static Logger logger = LoggerFactory.getLogger(ApacheHttpClientFactory.class);

    private KeyManager[] keyManagers;
    private TrustManager[] trustManagers;
    private SecureRandom secureRandom;

    @PostConstruct
    public void init() {
        keyManagers = new KeyManager[0];
        secureRandom = new SecureRandom();

        HttpsTrustManager trustManager = new HttpsTrustManager();
        trustManagers = new TrustManager[] { trustManager };
    }

    public HttpClient get() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setSSLContext(buildDefaultSSLContext());
        return httpClientBuilder.build();
    }


    private SSLContext buildDefaultSSLContext() {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
            sslContext.init(keyManagers, trustManagers, secureRandom);
        } catch (Exception e) {
            logger.error("Failed to build default SSL Context", e);
        }
        return sslContext;
    }
}