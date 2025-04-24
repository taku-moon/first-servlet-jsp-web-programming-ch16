package com.example.ch16.controller;

import com.example.ch16.service.MemberService;
import com.example.ch16.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberUpdateController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
            request.setAttribute("error", "아이디, 비밀번호, 이름은 필수입니다.");
            return "/memberUpdate";
        }

        MemberVo member = new MemberVo(id, password, name, email);

        MemberService service = MemberService.getInstance();
        service.memberUpdate(member);

        request.setAttribute("id", id);

        return "memberUpdateOutput";
    }
}
