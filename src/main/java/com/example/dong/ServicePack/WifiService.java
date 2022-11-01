package com.example.dong.ServicePack;


import com.example.dong.DAO.WifiDao;
import com.example.dong.DTO.WifiDto;
import com.example.dong.Domain.WifiInfo01;
import com.example.dong.Jdbc.JdbcUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WifiService {

    private static final String openAPIname = "TbPublicWifiInfo"; // OpenAPI 데이터 이름
    private static final String fileType = "json"; // 파싱할 데이터 타입
    private static final String key = "/6369747a48656864373265646f6474/"; // OpenAPI key

    private static final String urlPrototype = "http://openapi.seoul.go.kr:8088" + "/" + key + "/" + fileType + "/" + openAPIname; // 기본 url

    public static WifiDao wifidao  = new WifiDao(); // DAO 클래스 사용을 위한 WifiDao 객체 선언

    // OpenAPI Data의 개수 구해주는 메소드
    public int getDataSize() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://openapi.seoul.go.kr:8088/6369747a48656864373265646f6474/json/TbPublicWifiInfo/0/1/";
        int dataSize = 0;

        Response response = null;
        Request request = new Request.Builder().url(url).build(); // 주어지느 url에 대한 요청 객체

        Gson gson = new GsonBuilder().create();
        JSONParser parser = new JSONParser();

        try {
            response = client.newCall(request).execute();
            JSONObject obj = (JSONObject) parser.parse(response.body().string());
            JSONObject openAPIInfo = (JSONObject) obj.get(openAPIname);
            dataSize = Integer.parseInt(openAPIInfo.get("list_total_count").toString());

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            JdbcUtil.close(response);

        }
        return dataSize;
    }
    // OpenAPI 데이터를 저장하는 메소드

    public int insertOpenAPIData() throws Exception {

        int dataSize = getDataSize();
        int savedData = 0;

        for (int i = 0; i < ((dataSize / 1000) + 1) * 1000; i += 1000) {

            OkHttpClient client = new OkHttpClient();
            int startP = i;
            int endP = i + 999;

            JSONParser parser = new JSONParser();
            ArrayList<WifiInfo01> wifiInfo01 = new ArrayList<>(); // 결과를 담을 객체 배열
            String url = "http://openapi.seoul.go.kr:8088/6369747a48656864373265646f6474/json/TbPublicWifiInfo/" + startP + "/" + endP + "/"; // 원하는 데이터의 범위를 가지는 url

            Request request = new Request.Builder().url(url).addHeader("Content-Type", "application/json; charset=utf-8").build();


            try {
                Response response = client.newCall(request).execute();
                JSONObject obj = (JSONObject) parser.parse(response.body().string());
                JSONObject openAPIInfo = (JSONObject) obj.get("TbPublicWifiInfo");
                JSONArray arr = (JSONArray) openAPIInfo.get("row");

                for (int j = 0; j < arr.size(); j++) {
                    JSONObject ob = (JSONObject) arr.get(j);
                    WifiInfo01 wifi = WifiInfo01.builder()
                            .Wifi_no(ob.get("X_SWIFI_MGR_NO").toString())
                            .Gu(ob.get("X_SWIFI_WRDOFC").toString())
                            .Wifi_name(ob.get("X_SWIFI_MAIN_NM").toString())
                            .Road_Address(ob.get("X_SWIFI_ADRES1").toString())
                            .Address(ob.get("X_SWIFI_ADRES2").toString())
                            .InstalledFloor(ob.get("X_SWIFI_INSTL_FLOOR").toString())
                            .InstallType(ob.get("X_SWIFI_INSTL_TY").toString())
                            .installAgency(ob.get("X_SWIFI_INSTL_MBY").toString())
                            .ServiceType(ob.get("X_SWIFI_SVC_SE").toString())
                            .NetworkType(ob.get("X_SWIFI_CMCWR").toString())
                            .InstalledYear(ob.get("X_SWIFI_CNSTC_YEAR").toString())
                            .InOutType(ob.get("X_SWIFI_INOUT_DOOR").toString())
                            .AccessType(ob.get("X_SWIFI_REMARS3").toString())
                            .x(ob.get("LNT").toString()) //x
                            .y(ob.get("LAT").toString()) //y
                            .date(ob.get("WORK_DTTM").toString())
                            .build();
                    wifiInfo01.add(wifi); // 저장
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return savedData;
            }
            savedData += wifidao.insertWifi(wifiInfo01);
            wifiInfo01.clear();
        }
        return savedData; // 저장된 데이터 개수 반환
    }

    public List<WifiDto> getInfo(String x, String y) throws SQLException, ClassNotFoundException {
        return wifidao.selectWifi(x,y);
        // 20개의 근처 wifi 위치가 담긴 객체 배열 리턴!
    }

    public List<WifiDto> selectAllWifi() throws SQLException {
        return wifidao.selectAllWifi();
    } // 모든 wifi 정보 return 햐주는 메소드
}




