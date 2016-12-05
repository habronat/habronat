package com.habronat.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "real_estate_adverts")
public class RealEstateAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advert_metadata_fk")
    private AdvertMetadata advertMetadata;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AdvertMetadata getAdvertMetadata() {
        return advertMetadata;
    }

    public void setAdvertMetadata(AdvertMetadata advertMetadata) {
        this.advertMetadata = advertMetadata;
    }
}
