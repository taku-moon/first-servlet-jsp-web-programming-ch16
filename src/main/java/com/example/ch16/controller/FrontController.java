package com.example.ch16.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        initParams = @WebInitParam(name = "charset", value = "UTF-8"),
        urlPatterns = "*.do"
)
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String charset;
    Map<String, Controller> subControllers;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        charset = config.getInitParameter("charset");

        subControllers = new HashMap<>();
        subControllers.put("/memberInsert.do", new MemberInsertController());
        subControllers.put("/memberSearch.do", new MemberSearchController());
        subControllers.put("/memberUpdate.do", new MemberUpdateController());
        subControllers.put("/memberDelete.do", new MemberDeleteController());
        subControllers.put("/memberList.do", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(charset);

        String path = request.getRequestURI();

        Controller subController = subControllers.get(path);
        subController.execute(request, response);
    }
}
