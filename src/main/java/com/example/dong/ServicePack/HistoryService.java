package com.example.dong.ServicePack;


import com.example.dong.DAO.WifiDao;
import com.example.dong.Domain.WifiInfo02;

import java.sql.SQLException;
import java.util.ArrayList;

public class HistoryService {

    public static WifiDao wifidao  = new WifiDao();


    // 히스토리 내역 저장
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int insertHistory(String x, String y) throws Exception {
        return wifidao.insertHistory(x,y);
    }
    // 히스토리 내역 가져오기
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<WifiInfo02> selectHistory() throws SQLException {
        return wifidao.selectHistory();
    }
    // 히스토리 내역 삭제하기
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int deleteHistory (String id) throws SQLException {
        return wifidao.deleteHistory(id);
    }

}
