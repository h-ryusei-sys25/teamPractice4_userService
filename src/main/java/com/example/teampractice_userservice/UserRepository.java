package com.example.teampractice_userservice;

public interface UserRepository {

    boolean existsByEmail(String email);

//    existsByEmailを実行して問題なかったときそのユーザーを保存する
    void save( String name , String email );
}