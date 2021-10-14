package com.example.demo.entity;

import com.example.demo.constant.CityName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
public class City extends NBEntity {

    @Getter
    @Setter
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<EstablishmentAddress> addressList;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private CityName name;
}
