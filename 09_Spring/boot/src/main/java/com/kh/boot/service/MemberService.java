package com.kh.boot.service;

import com.kh.boot.domain.vo.Member;

public interface MemberService {
    //login
    Member loginMember(Member m);

    //회원가입
    int insertMember(Member m);
}
