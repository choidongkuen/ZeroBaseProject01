package com.example.dong.Servlet;

import com.example.dong.DTO.WifiDto;

import com.example.dong.Domain.WifiInfo01;
import com.example.dong.ServicePack.DistanceCal;
import com.example.dong.ServicePack.HistoryService;
import com.example.dong.ServicePack.WifiService;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet("/aroundWifi")

public class WifiServlet extends HttpServlet {

    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    @SneakyThrows
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


        String x = request.getParameter("x");
        String y = request.getParameter("y");
        HistoryService historyService = new HistoryService();
        historyService.insertHistory(x,y);

        WifiService wifiService = new WifiService();
        // 여기까진 정상적으로 됨...

        List<WifiDto> wifiList = wifiService.getInfo(x,y);
        List<WifiDto> result = new ArrayList<>();

        Collections.sort(wifiList);

        for (int i = 0; i < 20 ; i++) {
            result.add(wifiList.get(i));
        }

        request.setAttribute("nearWifiData", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}