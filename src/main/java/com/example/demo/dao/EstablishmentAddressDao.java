package com.example.demo.dao;

import com.example.demo.entity.EstablishmentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentAddressDao extends JpaRepository<EstablishmentAddress, String> {
}
