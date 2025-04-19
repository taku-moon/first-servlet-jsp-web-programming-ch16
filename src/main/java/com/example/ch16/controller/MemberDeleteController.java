package com.example.ch16.controller;

import com.example.ch16.controller.util.HttpUtil;
import com.example.ch16.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberDeleteController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        MemberService service = MemberService.getInstance();
        service.memberDelete(id);

        HttpUtil.forward(request, response, "/result/memberDeleteOutput.jsp");
    }
}
