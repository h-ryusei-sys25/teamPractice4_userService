package com.example.teampractice_userservice;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        // existsByEmailでtrueならIllegalStateExceptionをスローし、falseなら保存処理をする
        String email =  user.getMailAddress() ;
        if (userRepository.existsByEmail(email) ){
            throw new IllegalStateException();
        } else {
            userRepository.save(user);
        }
    }
}
