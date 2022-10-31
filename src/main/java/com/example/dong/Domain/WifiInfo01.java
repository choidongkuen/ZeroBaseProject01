package com.example.dong.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter
@Setter



public class WifiInfo01 {


    private String Wifi_no;          //    X_SWIFI_MGR_NO": "ARI00001",
    private String Gu;          //    "X_SWIFI_WRDOFC": "서대문구",
    private String Wifi_name;        //    "X_SWIFI_MAIN_NM": "상수도사업본부",
    private String Road_Address;    //    "X_SWIFI_ADRES1": "서소문로 51",
    private String Address;    //    "X_SWIFI_ADRES2": "본관 1F",
    private String InstalledFloor; //    "X_SWIFI_INSTL_FLOOR": "",
    private String InstallType;            //    "X_SWIFI_INSTL_TY": "7-1. 공공 - 행정",
    private String installAgency;           //    "X_SWIFI_INSTL_MBY": "서울시(AP)",
    private String ServiceType;         //    "X_SWIFI_SVC_SE": "공공WiFi",
    private String NetworkType;         //    "X_SWIFI_CMCWR": "수도사업소자가망",
    private String InstalledYear;            //    "X_SWIFI_CNSTC_YEAR": "2014",
    private String InOutType;            //    "X_SWIFI_INOUT_DOOR": "실내",
    private String AccessType;            //    "X_SWIFI_REMARS3": "",
    private String x;               //  "LNT": "37.561924",
    private String y;           //  "LAT": "126.96675",
    private String date;    //    "WORK_DTTM": "2022-10-17 10:58:03.0"


    public WifiInfo01(String wifi_no, String gu, String wifi_name, String road_Address, String address, String installedFloor, String installType, String installAgency, String serviceType, String networkType, String installedYear, String inOutType, String accessType, String x, String y, String date) {
        Wifi_no = wifi_no;
        Gu = gu;
        Wifi_name = wifi_name;
        Road_Address = road_Address;
        Address = address;
        InstalledFloor = installedFloor;
        InstallType = installType;
        this.installAgency = installAgency;
        ServiceType = serviceType;
        NetworkType = networkType;
        InstalledYear = installedYear;
        InOutType = inOutType;
        AccessType = accessType;
        this.x = x;
        this.y = y;
        this.date = date;
    }

    public String getWifi_no() {
        return Wifi_no;
    }

    public void setWifi_no(String wifi_no) {
        Wifi_no = wifi_no;
    }

    public String getGu() {
        return Gu;
    }

    public void setGu(String gu) {
        Gu = gu;
    }

    public String getWifi_name() {
        return Wifi_name;
    }

    public void setWifi_name(String wifi_name) {
        Wifi_name = wifi_name;
    }

    public String getRoad_Address() {
        return Road_Address;
    }

    public void setRoad_Address(String road_Address) {
        Road_Address = road_Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getInstalledFloor() {
        return InstalledFloor;
    }

    public void setInstalledFloor(String installedFloor) {
        InstalledFloor = installedFloor;
    }

    public String getInstallType() {
        return InstallType;
    }

    public void setInstallType(String installType) {
        InstallType = installType;
    }

    public String getInstallAgency() {
        return installAgency;
    }

    public void setInstallAgency(String installAgency) {
        this.installAgency = installAgency;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getNetworkType() {
        return NetworkType;
    }

    public void setNetworkType(String networkType) {
        NetworkType = networkType;
    }

    public String getInstalledYear() {
        return InstalledYear;
    }

    public void setInstalledYear(String installedYear) {
        InstalledYear = installedYear;
    }

    public String getInOutType() {
        return InOutType;
    }

    public void setInOutType(String inOutType) {
        InOutType = inOutType;
    }

    public String getAccessType() {
        return AccessType;
    }

    public void setAccessType(String accessType) {
        AccessType = accessType;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}