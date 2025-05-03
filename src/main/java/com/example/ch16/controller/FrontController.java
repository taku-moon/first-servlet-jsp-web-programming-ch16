package com.example.ch16.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/*")
public class FrontController extends HttpServlet {

    private final Map<String, Controller> subControllers = Map.of(
            "/index.jsp", new HomePageController(),
            "/memberInsert.jsp", new MemberInsertPageController(),
            "/memberSearch.jsp", new MemberSearchPageController(),
            "/memberUpdate.jsp", new MemberUpdatePageController(),
            "/memberDelete.jsp", new MemberDeletePageController(),

            "/memberInsert.do", new MemberInsertController(),
            "/memberSearch.do", new MemberSearchController(),
            "/memberUpdate.do", new MemberUpdateController(),
            "/memberDelete.do", new MemberDeleteController(),
            "/memberList.do", new MemberListController()
    );

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        Controller subController = subControllers.get(uri);

        if (subController == null) {
            System.out.println("No such controller: " + uri);
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String view = subController.execute(request, response);
        String viewPath = "/WEB-INF/views/" + view + ".jsp";

        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
