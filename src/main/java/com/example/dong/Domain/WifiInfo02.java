package com.example.dong.Domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter
@Setter

public class WifiInfo02 {

    private long wifi_id; // wifi 아이디
    private String x; // x 좌표
    private String y; // y 좌표
    private String date; // 조회 일자

    public WifiInfo02(long wifi_id, String x, String y, String date) {
        this.wifi_id = wifi_id;
        this.x = x;
        this.y = y;
        this.date = date;
    }

}