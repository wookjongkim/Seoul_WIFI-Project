package com.example.seoul_wifiproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bookmark {
    private int id;
    private String bookmark_name;
    private int groupOrder;
    private String register_date;
    private String modified_date;
}
