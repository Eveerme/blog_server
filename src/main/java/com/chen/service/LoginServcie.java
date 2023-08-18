package com.chen.service;

import com.chen.controller.login.request.UserLoginRequest;
import com.chen.utils.ResponseResult;

public interface LoginServcie {
    ResponseResult login(UserLoginRequest user);
    ResponseResult logout();

    ResponseResult register();
}
