package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class EstablishmentAddress extends NBEntity {
    private static final long serialVersionUID = 4047117455308498306L;
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "establishmentAddress")
    private Society society;
    @Getter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private City city;

    public void setCity(final City city) {
        this.city = city;
        if (!city.getAddressList().contains(this)) {
            city.getAddressList().add(this);
        }
    }
}
