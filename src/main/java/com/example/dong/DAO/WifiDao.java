package com.example.dong.DAO;

import com.example.dong.DTO.WifiDto;
import com.example.dong.Domain.WifiInfo01;
import com.example.dong.Domain.WifiInfo02;
import com.example.dong.Jdbc.JdbcUtil;
import com.example.dong.Jdbc.ProvideConnection;
import com.example.dong.ServicePack.DistanceCal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WifiDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;

    // OpenAPI 로부터 가져온 모든 데이터 DB (WifiInfo01 테이블)에 모두 저장하는 매소드
    // from WifiService
    public int insertWifi(List<WifiInfo01> wifiInfo01) throws Exception{
        int cnt = 0; // 데이터의 개수
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String sql = " insert into wifi_info01 values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            // connection 객체 생성
            conn = ProvideConnection.getConnection();
            for (int i = 0; i < wifiInfo01.size() ; i++) {

                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, wifiInfo01.get(i).getWifi_no());
                pstmt.setString(2, wifiInfo01.get(i).getGu());
                pstmt.setString(3, wifiInfo01.get(i).getWifi_name());
                pstmt.setString(4, wifiInfo01.get(i).getRoad_Address());
                pstmt.setString(5, wifiInfo01.get(i).getAddress());
                pstmt.setString(6, wifiInfo01.get(i).getInstalledFloor());
                pstmt.setString(7, wifiInfo01.get(i).getInstallType());
                pstmt.setString(8, wifiInfo01.get(i).getInstallAgency());
                pstmt.setString(9, wifiInfo01.get(i).getServiceType());
                pstmt.setString(10, wifiInfo01.get(i).getNetworkType());
                pstmt.setString(11, wifiInfo01.get(i).getInstalledYear());
                pstmt.setString(12, wifiInfo01.get(i).getInOutType());
                pstmt.setString(13, wifiInfo01.get(i).getAccessType());
                pstmt.setString(14, wifiInfo01.get(i).getX());
                pstmt.setString(15, wifiInfo01.get(i).getY());
                pstmt.setString(16, wifiInfo01.get(i).getDate());

                int rs = pstmt.executeUpdate();

                if(rs > 0) {
                    cnt++;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }
        return cnt;
    }

    // 조회한 기록을 wifiInfo02에 저장하는 메소드(검색 내역 저장)
    // from HistoryService
    public int insertHistory(String x, String y) throws Exception{
        int result = 0;

        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String sql = " insert into wifi_info02 " +
                    " VALUES(null,?,?,now()) " ;

            conn = ProvideConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,x);
            pstmt.setString(2,y);

            result = pstmt.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }
        return result;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // 불러온 데이터로부터 가까운 20개의 wifi 선택하는 메소드
    // from WifiService
    public List<WifiDto> selectWifi(String x, String y) throws SQLException, ClassNotFoundException {

        String sql = " select * from wifi_info01 ";
        List<WifiDto> wifiList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Class.forName("org.mariadb.jdbc.Driver");

        try{
            conn = ProvideConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String x2 = rs.getString("x");
                String y2 = rs.getString("y");

                double dist = DistanceCal.getDistance(x,y,x2,y2); // 기준이 되는 좌표와의 거리 계산
                String distance = String.valueOf(dist); // 거리는 DB 상 문자열로 처리
                double finalDis = Double.parseDouble(distance);

                WifiDto wifi = new WifiDto(
                        rs.getString("Wifi_no"),
                        rs.getString("Gu"),
                        rs.getString("Wifi_name"),
                        rs.getString("Road_Address"),
                        rs.getString("Address"),
                        rs.getString("InstalledFloor"),
                        rs.getString("InstallType"),
                        rs.getString("installAgency"),
                        rs.getString("ServiceType"),
                        rs.getString("NetworkType"),
                        rs.getString("NetworkType"),
                        rs.getString("InOutType"),
                        rs.getString("AccessType"),
                        rs.getString("x"),
                        rs.getString("y"),
                        rs.getString("date"),
                        finalDis
                );
                wifiList.add(wifi);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }

        return wifiList; // 결과 리턴
    }


//     모든 저장된 wifi 정보를 select 하는 메소드
//     from WifiService

    public List<WifiDto> selectAllWifi() throws SQLException {

        String sql = " SELECT * FROM wifi_info01 ";

        List<WifiDto> dataList = new ArrayList<>();
        conn = ProvideConnection.getConnection();
        pstmt = null;
        ResultSet rs = null;

        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                dataList.add(WifiDto.builder()

                        .wifi_no(rs.getString("Wifi_no"))
                        .gu(rs.getString("Gu"))
                        .wifi_name(rs.getString("Wifi_name"))
                        .road_Address(rs.getString("Road_address"))
                        .address(rs.getString("Address"))
                        .installedFloor(rs.getString("InstalledFloor"))
                        .installType(rs.getString("InstallType"))
                        .installAgency(rs.getString("InstallAgency"))
                        .serviceType(rs.getString("ServiceType"))
                        .networkType(rs.getString("NetworkType"))
                        .installedYear(rs.getString("InstalledYear"))
                        .inOutType(rs.getString("InOutType"))
                        .accessType(rs.getString("AccessType"))
                        .x(rs.getString("x"))
                        .y(rs.getString("y"))
                        .date(rs.getString("date")).build()
                );
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }
        return dataList;
    }


    // 검색 기록을 보여주는 메소드
    // from HistoryService
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<WifiInfo02> selectHistory() throws SQLException {
        ArrayList<WifiInfo02> list = new ArrayList<>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String sql = " select * from wifi_info02 " +
                    " order by Wifi_id desc ";
            conn = ProvideConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(WifiInfo02.builder()
                        .wifi_id(rs.getInt("Wifi_id"))
                        .x(rs.getString("x"))
                        .y(rs.getString("y"))
                        .date(rs.getString("date"))
                        .build());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }
        return list; // 결과 리턴
    }

    // 기록을 삭제하는 메소드
    // from HistoryService
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public int deleteHistory(int id) throws SQLException {
        int result = 0;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String sql = " delete from wifi_info02 " +
                    " where Wifi_id = ? ";

            conn = ProvideConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            result = pstmt.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }
        return result; // 결과 리턴
    }

}
