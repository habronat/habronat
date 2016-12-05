package com.habronat.domain.repository;

import com.habronat.domain.RepositoryTest;
import com.habronat.domain.model.AdvertMetadata;
import com.habronat.domain.model.RealEstateAdvert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RealEstateAdvertRepositoryTest extends RepositoryTest {

    @Autowired
    private RealEstateAdvertRepository realEstateAdvertRepository;

    @Test
    public void save() {
        AdvertMetadata advertMetadata = new AdvertMetadata();
        advertMetadata.setUrl("http://url.com");

        RealEstateAdvert realEstateAdvert = new RealEstateAdvert();
        realEstateAdvert.setAdvertMetadata(advertMetadata);

        realEstateAdvertRepository.save(realEstateAdvert);

        Query query = em.createQuery("SELECT rea FROM RealEstateAdvert rea");
        List<RealEstateAdvert> realEstateAdverts = query.getResultList();

        assertThat(realEstateAdverts.size(), equalTo(1));
        assertThat(realEstateAdverts.get(0).getAdvertMetadata().getUrl(), equalTo("http://url.com"));
    }

}