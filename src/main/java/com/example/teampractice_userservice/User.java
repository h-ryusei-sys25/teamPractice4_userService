package com.example.teampractice_userservice;

public class User {
    private String name;
    private String mailAddress;

    public User(String name, String address) {
        this.name = name;
        this.mailAddress = address;
    }

    // --- ゲッターメソッド（Assertでの検証に使用します） ---


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
