package com.chen.controller.login.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenyingtao
 * @Date 2023/8/2 10:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    /*
    *
    * 用户名
    * */
    private String useraccount;
    /*
    *
    * 密码
    * */
    private String password;
}
