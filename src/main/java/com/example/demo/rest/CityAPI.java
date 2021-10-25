package com.example.demo.rest;

import com.example.demo.constant.CityName;
import com.example.demo.dao.CityDao;
import com.example.demo.entity.City;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityAPI {
    private final CityDao cityDao;

    public CityAPI(final CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Void> createCity(@RequestBody CityName cityName) {
                    final City city = new City();
        city.setName(cityName);
        cityDao.save(city);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityDao.findAll());
    }
}
