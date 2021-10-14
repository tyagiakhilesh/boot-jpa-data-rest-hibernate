package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "society")
public class Society extends NBEntity {
    private static final long serialVersionUID = -4128168073479516443L;
    @Getter
    @Setter
    @JoinColumn(name = "establishment_address")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private EstablishmentAddress establishmentAddress;
}
