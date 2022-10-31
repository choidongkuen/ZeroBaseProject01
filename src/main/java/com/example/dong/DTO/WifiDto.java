package com.example.dong.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Builder
@NoArgsConstructor
@Getter
@Setter


public class WifiDto implements Comparable<WifiDto>{
    //    private int Wifi_id;
    private String wifi_no; // 관리 번호
    private String gu; // 관리 구
    private String wifi_name; // 와이파이 이름
    private String road_Address; // 도로명 주소
    private String address; // 상세 주소
    private String installedFloor; // 섩치 위치(층)
    private String installType; // 설치 유형
    private String installAgency; // 설치 기관
    private String serviceType; // 서비스 유형
    private String networkType; // 망 종류
    private String installedYear; // 설치 년도
    private String inOutType; // 실내외 구분
    private String accessType; // wifi 접속 환경
    private String x; // x 좌표
    private String y; // y 좌표
    private String date; // 작업일자

    private double distance; // target 위치부터 거리

    public WifiDto(String wifi_no, String gu, String wifi_name, String road_Address, String address, String installedFloor, String installType, String installAgency, String serviceType, String networkType, String installedYear, String inOutType, String accessType, String x, String y, String date,double distance) {

        this.wifi_no = wifi_no;
        this.gu = gu;
        this.wifi_name = wifi_name;
        this.road_Address = road_Address;
        this.address = address;
        this.installedFloor = installedFloor;
        this.installType = installType;
        this.installAgency = installAgency;
        this.serviceType = serviceType;
        this.networkType = networkType;
        this.installedYear = installedYear;
        this.inOutType = inOutType;
        this.accessType = accessType;
        this.x = x;
        this.y = y;
        this.date = date;
        this.distance = distance;

    }
    @Override
    public int compareTo(@NotNull WifiDto o) {
        return (int)this.getDistance() - (int)o.getDistance();
    }
}
