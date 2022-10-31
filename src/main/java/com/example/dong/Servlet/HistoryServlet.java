package com.example.dong.Servlet;

import com.example.dong.ServicePack.HistoryService;
import com.example.dong.ServicePack.HistoryService;
import com.example.dong.Domain.WifiInfo02;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "history", value = "/history")

public class HistoryServlet extends HttpServlet {

    @SneakyThrows
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        HistoryService service = new HistoryService();
        ArrayList<WifiInfo02> histories = service.selectHistory();

        request.setAttribute("histories",histories);
        // request 객체를 통해 histories 결과 전송(to ShowHistory.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowHistory.jsp" );
        // 저장된 검색 내역 객체 배열을 보냄 (histories)
        dispatcher.forward(request,response);
    }
}
