package com.example.seoul_wifiproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Favorite {
    private int id;
    private String bookmark_name;
    private String wifiName;
    private String register_date;
}
