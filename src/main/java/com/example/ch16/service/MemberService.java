package com.example.ch16.service;

import com.example.ch16.dao.MemberDAO;
import com.example.ch16.vo.MemberVo;

import java.util.List;

public class MemberService {
    private static MemberService service = new MemberService();

    private MemberService() {
    }

    public static MemberService getInstance() {
        return service;
    }

    public void memberInsert(MemberVo member) {
        MemberDAO.memberInsert(member);
    }

    public void memberUpdate(MemberVo member) {
        MemberDAO.memberUpdate(member);
    }

    public void memberDelete(String id) {
        MemberDAO.memberDelete(id);
    }

    public MemberVo memberSearch(String id) {
        return MemberDAO.memberSearch(id);
    }

    public List<MemberVo> memberList() {
        return MemberDAO.memberList();
    }
}
