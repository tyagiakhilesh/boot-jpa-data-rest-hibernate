package com.example.demo.rest;

import com.example.demo.constant.CityName;
import com.example.demo.dao.CityDao;
import com.example.demo.dao.SocietyDao;
import com.example.demo.entity.City;
import com.example.demo.entity.EstablishmentAddress;
import com.example.demo.entity.Society;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/society")
public class SocietyAPI {
    private final CityDao cityDao;
    private final SocietyDao societyDao;

    public SocietyAPI(final CityDao cityDao, final SocietyDao societyDao) {
        this.cityDao = cityDao;
        this.societyDao = societyDao;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Void> createSociety(@RequestBody CityName cityName) {
        final Society s = new Society();
        final EstablishmentAddress establishmentAddress = new EstablishmentAddress();
        City c = cityDao.findCityByName(cityName);
        if (null == c) {
            c = new City();
            c.setName(cityName);
            try {
                cityDao.save(c);
            } catch (Exception e) {
                if (e instanceof SQLIntegrityConstraintViolationException) {
                    //ignore
                } else {
                    throw e;
                }
            }
        }
        establishmentAddress.setCity(cityDao.findCityByName(cityName));
        s.setEstablishmentAddress(establishmentAddress);
        societyDao.save(s);
        return ResponseEntity.ok().build();
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "city")
    public ResponseEntity<List<Society>> getSocietiesForCity(@RequestBody CityName cityName) {
        final City c = cityDao.findCityByName(cityName);
        if (null == c) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(c.getAddressList().stream().map(EstablishmentAddress::getSociety).collect(Collectors.toList()));
    }
}


