package com.chen.controller.login;

import com.chen.controller.login.request.UserLoginRequest;
import com.chen.service.LoginServcie;
import com.chen.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenyingtao
 * @Date 2023/7/24 13:16
 */
@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;


    @PostMapping("/user/login")
    public ResponseResult loginIn(@RequestBody UserLoginRequest user){
        return loginServcie.login(user);
    }

    @GetMapping("/user/logout")
    public ResponseResult logoutIn(){
        return loginServcie.logout();
    }

    @GetMapping("/user/register")
    public ResponseResult register(){
        return loginServcie.register();
    }
}


