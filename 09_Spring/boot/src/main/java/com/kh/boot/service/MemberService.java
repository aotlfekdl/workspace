package com.kh.boot.service;

import com.kh.boot.domain.vo.Member;

public interface MemberService {
    //login
    Member loginMember(String userId);

    //회원가입
    int insertMember(Member m);

    //아이디 중복 조회(count)
    int idCheck(String userId);
}
