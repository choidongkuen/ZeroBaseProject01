package com.example.dong.Servlet;


import com.example.dong.Domain.WifiInfo01;
import com.example.dong.ServicePack.HistoryService;
import com.example.dong.Domain.WifiInfo02;
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
import java.util.List;

@WebServlet("/removeHistory")
public class HistoryDelServlet extends HttpServlet {
    @SneakyThrows
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);

    }

    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String type = request.getParameter("id");
        int id = Integer.parseInt(request.getParameter("id")); // 가져온 id

        ArrayList<WifiInfo02> histories = new ArrayList<>(); // 삭제 후 결과를 담을 배열리스트

        HistoryService service = new HistoryService();

        if(id > 0){
            service.deleteHistory(id);
            histories = service.selectHistory();
        }

        request.setAttribute("histories", histories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowHistory.jsp");
        dispatcher.forward(request,response);

    }
}
