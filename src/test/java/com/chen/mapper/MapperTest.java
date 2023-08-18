package com.chen.mapper;

import com.chen.pojo.po.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * @Author chenyingtao
 * @Date 2023/7/24 14:59
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void testUserMapper(){
        List<Manager> managers = userMapper.selectList(null);
        System.out.println("users:=======" + managers);
    }

    @Test
    public void testUserDetailsService(){
        UserDetails userDetails = userDetailsService.loadUserByUsername("root");
        System.out.println("users:=======" + userDetails);
    }


    @Test
    @PreAuthorize("hasAuthority('test')")
    public void testPassword(){
        String password = new BCryptPasswordEncoder().encode("123456");
        System.out.println("password:=======" + password);
    }
}
