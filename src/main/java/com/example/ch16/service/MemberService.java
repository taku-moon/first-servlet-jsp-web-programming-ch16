package com.example.ch16.service;

import com.example.ch16.dao.MemberDAO;
import com.example.ch16.vo.MemberVo;

import java.util.List;

public class MemberService {
    private static MemberService service = new MemberService();
    private MemberDAO dao = MemberDAO.getInstance();

    private MemberService() {
    }

    public static MemberService getInstance() {
        return service;
    }

    public void memberInsert(MemberVo member) {
        dao.memberInsert(member);
    }

    public MemberVo memberSearch(String id) {
        return dao.memberSearch(id);
    }

    public void memberUpdate(MemberVo member) {
        dao.memberUpdate(member);
    }

    public void memberDelete(String id) {
        dao.memberDelete(id);
    }

    public List<MemberVo> memberList() {
        return dao.memberList();
    }
}
