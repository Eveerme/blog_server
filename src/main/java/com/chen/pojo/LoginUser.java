package com.chen.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private String userType;
    private String userId;
    private String userName;
    private String userNickName;
    private String password;

    // 存储权限信息
    private List<String> permissions;

    public LoginUser(String userType, String userId, String userName, String userNickName, String password, List<String> permissions) {
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userNickName = userNickName;
        this.permissions = permissions;
    }

    // 存储SpringSecurity所需要的权限信息的集合
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        // Assuming your manager object has a getPassword() method
        // You might need to adjust this based on the actual methods in the T class
        return password;
    }

    @Override
    public String getUsername() {
        // Assuming your manager object has a getUserName() method
        // You might need to adjust this based on the actual methods in the T class
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
