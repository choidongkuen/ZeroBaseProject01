package com.example.dong.ServicePack;

public class DistanceCal {
    public static final double TODIS = 60*1.1515*1609.344;

    public static double getDistance(String x1, String y1, String x2, String y2){

        double lat1 = Double.parseDouble(x1);
        double lnt1 = Double.parseDouble(y1);
        double lat2 = Double.parseDouble(x2);
        double lnt2 = Double.parseDouble(y2);

        double val = lnt1 - lnt2;

        double dist = Math.sin(toRadian(lat1))* Math.sin(toRadian(lat2)) + Math.cos(toRadian(lat1))*Math.cos(toRadian(lat2))*Math.cos(toRadian(val));
        dist = Math.acos(dist);
        dist = toDeci(dist);
        // 십진수값으로 변경
        dist = dist * TODIS;

        return  Math.round(dist/1000*100)/100.0;

    }

    private static double toRadian(double val){
        return val * Math.PI/180.0;
    }
    private static double toDeci(double val){
        return val * 180.0 / Math.PI;
    }
}
