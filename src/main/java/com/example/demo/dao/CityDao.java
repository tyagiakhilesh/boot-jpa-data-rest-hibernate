package com.example.demo.dao;

import com.example.demo.constant.CityName;
import com.example.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City, String> {
    City findCityByName(CityName cityName);
}
