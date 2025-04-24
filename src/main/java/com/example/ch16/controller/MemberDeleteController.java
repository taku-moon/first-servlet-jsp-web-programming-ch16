package com.example.ch16.controller;

import com.example.ch16.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberDeleteController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberService service = MemberService.getInstance();
        service.memberDelete(request.getParameter("id"));

        return "memberDeleteOutput";
    }
}
