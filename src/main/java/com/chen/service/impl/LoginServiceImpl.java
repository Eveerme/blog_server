package com.chen.service.impl;

import com.chen.controller.login.request.UserLoginRequest;
import com.chen.controller.login.response.UserLoginResponse;
import com.chen.pojo.LoginUser;
import com.chen.pojo.po.Manager;
import com.chen.service.LoginServcie;
import com.chen.utils.JwtUtil;
import com.chen.utils.RedisCache;
import com.chen.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author chenyingtao
 * @Date 2023/7/24 15:28
 */
@Service
public class LoginServiceImpl implements LoginServcie {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(UserLoginRequest user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUseraccount(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = ( LoginUser ) authenticate.getPrincipal();
        String userId = loginUser.getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        UserLoginResponse userLoginResponse = UserLoginResponse
                            .builder()
                            .id(loginUser.getUserId())
                            .userType(loginUser.getUserType())
                            .userName(loginUser.getUsername())
                            .nickName(loginUser.getUserNickName())
                            .build();
        //把token响应给前端
        HashMap<String,Object> map = new HashMap<>();
        map.put("token",jwt);
        // 把用户信息响应前端
        map.put("user",userLoginResponse);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getUserId();
        redisCache.deleteObject("login:"+userid);
        return new ResponseResult(200,"退出成功");
    }

    @Override
    public ResponseResult register() {
        String userName  = "root";
        String password = new BCryptPasswordEncoder().encode("123456");
        Manager manager = new Manager();
        manager.setManagerName(userName);
        manager.setPassword(password);

        return new ResponseResult(200,"创建成功");
    }


}


