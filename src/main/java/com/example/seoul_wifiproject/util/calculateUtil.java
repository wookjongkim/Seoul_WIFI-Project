package com.example.seoul_wifiproject.util;

public class calculateUtil {
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2){
        double earth = 6371;
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double d = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(d), Math.sqrt(1-d));
        double distance = earth * c;

        return distance;
    }
}
