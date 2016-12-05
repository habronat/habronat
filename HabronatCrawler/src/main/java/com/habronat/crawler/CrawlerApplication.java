package com.habronat.crawler;

import com.habronat.domain.model.AdvertMetadata;
import com.habronat.domain.model.RealEstateAdvert;
import com.habronat.domain.repository.RealEstateAdvertRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class CrawlerApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CrawlerConfiguration.class);
        RealEstateAdvertRepository realEstateAdvertRepository = ctx.getBean(RealEstateAdvertRepository.class);

        AdvertMetadata advertMetadata = new AdvertMetadata();
        advertMetadata.setUrl("test1.com");

        RealEstateAdvert advert = new RealEstateAdvert();
        advert.setAdvertMetadata(advertMetadata);

        realEstateAdvertRepository.save(advert);
    }
}
