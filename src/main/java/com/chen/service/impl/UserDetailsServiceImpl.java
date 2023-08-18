package com.chen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chen.dao.ManagerDAO;
import com.chen.dao.StudentDAO;
import com.chen.dao.TeacherDAO;
import com.chen.pojo.LoginUser;
import com.chen.pojo.po.Manager;
import com.chen.pojo.po.Student;
import com.chen.pojo.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author chenyingtao
 * @Date 2023/7/24 15:14
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ManagerDAO managerDAO;
    @Autowired
    private TeacherDAO teacherDAO;
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        String userType = "";
        String userName = "";
        String userNickName = "";
        String password = "";
        List<String> permissionKeyList = new ArrayList<>();
        if (userId.startsWith("1")){
            LambdaQueryWrapper<Manager> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Manager::getId,userId);
            Manager manager = managerDAO.selectOne(wrapper);
            if(Objects.isNull(manager)){
                throw new RuntimeException("用户名或密码错误");
            }
            userType = "1";
            userName = manager.getManagerName();
            userNickName = manager.getNickName();
            password = manager.getPassword();
        } else if (userId.startsWith("2")){
            LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Teacher::getId,userId);
            Teacher teacher = teacherDAO.selectOne(wrapper);
            if(Objects.isNull(teacher)){
                throw new RuntimeException("用户名或密码错误");
            }
            userType = "2";
            userName = teacher.getNickName();
            userNickName = teacher.getNickName();
            password = teacher.getPassword();
        } else if (userId.startsWith("3")){
            LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Student::getId,userId);
            Student student = studentDAO.selectOne(wrapper);
            if(Objects.isNull(student)){
                throw new RuntimeException("用户名或密码错误");
            }
            userType = "3";
            userName = student.getStuName();
            userNickName = student.getNickName();
            password = student.getPassword();
        } else {
            throw new RuntimeException("用户名或密码错误");
        }
        return new LoginUser(userType, userId, userName, userNickName, password, permissionKeyList);

    }
}

