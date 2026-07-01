package com.example.teampractice_userservice;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String name , String email) {
        // existsByEmailでtrueならIllegalStateExceptionをスローし、falseなら保存処理をする
        if (userRepository.existsByEmail(email) ){
            throw new IllegalStateException();
        } else {
            userRepository.save( name , email );
        }
    }
}
