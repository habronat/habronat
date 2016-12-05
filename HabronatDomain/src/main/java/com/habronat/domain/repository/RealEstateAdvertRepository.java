package com.habronat.domain.repository;

import com.habronat.domain.model.RealEstateAdvert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RealEstateAdvertRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(RealEstateAdvert realEstateAdvert) {
        em.persist(realEstateAdvert);
    }
}
