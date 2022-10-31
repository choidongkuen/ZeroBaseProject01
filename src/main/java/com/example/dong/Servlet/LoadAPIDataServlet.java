package com.example.dong.Servlet;


import com.example.dong.ServicePack.WifiService;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loadApiData")
public class LoadAPIDataServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        WifiService service = new WifiService();
        int savedDataCnt = service.insertOpenAPIData();

        request.setAttribute("dataSize",savedDataCnt);
        // 저장된 데이터 갯수를 보냄( dataSize )
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GetOpenAPI.jsp");
        dispatcher.forward(request,response);
    }
}
