package com.example.ch16.controller;

import com.example.ch16.service.MemberService;
import com.example.ch16.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.NoSuchElementException;

public class MemberSearchController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String job = request.getParameter("job");
        String path = null;

        if (job.equals("search")) {
            path = "/memberSearch";
        } else if (job.equals("update")) {
            path = "/memberUpdate";
        } else if (job.equals("delete")) {
            path = "/memberDelete";
        }

        if (id.isEmpty()) {
            request.setAttribute("error", "아이디를 입력해 주세요.");
            return path;
        }

        MemberService service = MemberService.getInstance();

        try {
            MemberVo member = service.memberSearch(id);
            request.setAttribute("member", member);
        } catch (NoSuchElementException noSuchElementException) {
            request.setAttribute("result", "검색된 정보가 없습니다.");
        }

        if (job.equals("search")) {
            path = "memberSearchOutput";
        }

        return path;
    }
}
