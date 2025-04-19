package com.example.ch16.controller;

import com.example.ch16.controller.util.HttpUtil;
import com.example.ch16.service.MemberService;
import com.example.ch16.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSearchController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String job = request.getParameter("job");
        String path = null;

        if (job.equals("search")) {
            path = "/memberSearch.jsp";
        } else if (job.equals("update")) {
            path = "/memberUpdate.jsp";
        } else if (job.equals("delete")) {
            path = "/memberDelete.jsp";{}
        }

        if (id.isEmpty()) {
            request.setAttribute("error", "ID를 입력해 주세요.");
            HttpUtil.forward(request, response, path);
            return;
        }

        MemberService service = MemberService.getInstance();
        MemberVo member = service.memberSearch(id);
        if (member == null) {
            request.setAttribute("result", "검색된 정보가 없습니다.");
        }

        request.setAttribute("member", member);
        if (job.equals("search")) {
            path = "/result/memberSearchOutput.jsp";
        }

        HttpUtil.forward(request, response, path);
    }
}
