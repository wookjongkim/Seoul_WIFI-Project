package com.example.seoul_wifiproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WifiInfo {
    private double distanceKm;
    private String manageNum;
    private String district;
    private String wifiName;
    private String roadAddress;
    private String detailAddress;
    private String installationFloor;
    private String installationType;
    private String installationAgency;
    private String serviceType;
    private String networkType;
    private String installationYear;
    private String indoorOutdoor;
    private String wifiConnectionEnvironment;
    private double xCoordinate;
    private double yCoordinate;
    private String operationDate;
}
