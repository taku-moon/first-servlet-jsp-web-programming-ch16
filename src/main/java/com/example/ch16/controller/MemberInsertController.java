package com.example.ch16.controller;

import com.example.ch16.controller.util.HttpUtil;
import com.example.ch16.service.MemberService;
import com.example.ch16.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberInsertController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (id.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty()) {
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해 주세요.");
            HttpUtil.forward(request, response, "/memberInsert.jsp");
            return;
        }

        MemberVo member = new MemberVo();
        member.setId(id);
        member.setPassword(password);
        member.setName(name);
        member.setEmail(email);

        MemberService service = MemberService.getInstance();
        service.memberInsert(member);

        request.setAttribute("id", id);
        HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
    }
}
