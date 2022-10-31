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



/*
    List<WifiInfo02> histories = new ArrayList<>();
    String id = request.getParameter("remove");
//         ShowHistory.jsp 로 부터 request 인자를 받아옴


    HistoryService service = new HistoryService();
//        service.deleteHistory(id);
//        id가 정상적인 경우 해당 id를 가진 내역 삭제
*/


// RequestDispather : 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는 역할을 수행하거나
// 특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스이다! ( 일종의 포워딩 ? )

//        request.setAttribute("histories", histories); // 응답 객체 속성 지정
//                RequestDispatcher dispatcher = request.getRequestDispatcher("ShowHistory.jsp"); // 다시 ShowHistory.jsp로 이동
//                dispatcher.forward(request,response); // 포워딩