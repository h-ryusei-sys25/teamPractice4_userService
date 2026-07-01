package com.example.teampractice_userservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // MockitoをJUnit 5で有効化
class UserServiceTest {

    @Mock // 1. モック（偽物）を作成
    private UserRepository userRepository;

    @InjectMocks // 2. テスト対象にモックを自動注入
    private UserService userService;


    @Test
    @DisplayName("異常処理")
    void AbnormalityTest() {
        String name = "name";
        String email = "email";
//        userRepository.existsByEmail(email) が呼ばれた際、true（重複あり）を返すようにモックを設定する（when）。
        when(userRepository.existsByEmail(email)).thenReturn(true);

        // userService.register(...) を実行した際、IllegalStateException が発生することを assertThrows で検証する。
        assertThrows(IllegalStateException.class, () -> userService.register( name , email ));

        // 例外発生後は userRepository.save が一度も呼ばれていないことを verify(..., never()) で確認する。
        verify(userRepository, never()).save( name , email );
    }

    @Test
    @DisplayName("正常処理")
    void NormalTest() {
        String name = "name" ;
        String email = "email" ;

        // モックの設定
        when(userRepository.existsByEmail(email)).thenReturn(false);

        // Act（実行）：テスト対象メソッドを実行
        userService.register(name, email);

        // Verify（確認）：モックのメソッドが1回だけ、正しい引数で呼ばれたか確認
        verify(userRepository, times(1)).save(name, email);
    }
}