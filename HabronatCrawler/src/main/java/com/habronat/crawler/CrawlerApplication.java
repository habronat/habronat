package com.habronat.crawler;

import com.habronat.crawler.client.HttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class CrawlerApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = SpringApplication.run(CrawlerApplication.class, args);
        HttpClient httpClient = ctx.getBean(HttpClient.class);

        System.out.println(httpClient.get("http://irc.lv").getContent());
    }
}
