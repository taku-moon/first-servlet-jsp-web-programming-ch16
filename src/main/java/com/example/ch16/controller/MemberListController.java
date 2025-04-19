package com.example.ch16.controller;

import com.example.ch16.controller.util.HttpUtil;
import com.example.ch16.service.MemberService;
import com.example.ch16.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberService service = MemberService.getInstance();
        List<MemberVo> members = service.memberList();

       request.setAttribute("members", members);
       HttpUtil.forward(request, response, "/result/memberListOutput.jsp");
    }
}
