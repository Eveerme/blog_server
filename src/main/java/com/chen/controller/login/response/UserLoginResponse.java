package com.chen.controller.login.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenyingtao
 * @Date 2023/8/2 11:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户类型
     */
    private String userType;
}
