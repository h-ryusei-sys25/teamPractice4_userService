package com.example.teampractice_userservice;

public interface UserRepository {

    Boolean existsByEmail(String email);

//    existsByEmailを実行して問題なかったときそのユーザーを保存する
    void save(User user) ;
}