package com.example.demo.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum CityName {
    DELHI("Delhi"),
    GURGAON("Gurgaon"),
    NOIDA("Noida"),
    GREATER_NOIDA("Greater Noida"),
    JAIPUR("Jaipur"),
    AHMEDABAD("Ahmedabad"),
    MUMBAI("Mumbai"),
    SOUTH_MUMBAI("South Mumbai"),
    NAVI_MUMBAI("Navi Mumbai"),
    THANE("Thane"),
    PUNE("Pune"),
    NAGPUR("Nagpur"),
    KOLKATA("Kolkata"),
    HYDERABAD("Hyderabad"),
    BENGALURU("Bengaluru"),
    CHENNAI("Chennai"),
    KOCHI("Kochi");

    private final String displayName;

    CityName(final String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator
    public static CityName fromValue(@JsonProperty("cityName") final String cityName) {
        return CityName.valueOf(cityName);
    }

    public String getDisplayName() {
        return displayName;
    }
}
