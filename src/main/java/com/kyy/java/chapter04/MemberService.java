package com.kyy.java.chapter04;

@FunctionalInterface
public interface MemberService {
    boolean checkMember(String id, String password);
}
