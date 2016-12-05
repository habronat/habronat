package com.habronat.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Ignore
public class RepositoryTest {

    @Autowired
    protected EntityManager em;

    @Before
    public void setUp() {
        clean();
    }

    @Transactional
    protected void clean() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM RealEstateAdvert").executeUpdate();
        em.createQuery("DELETE FROM AdvertMetadata").executeUpdate();
        em.getTransaction().commit();
    }
}
