package com.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.StudentDAO;
import com.chen.pojo.po.Student;
import com.chen.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Author chenyingtao
 * @Date 2023/8/3 11:21
 */

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDAO, Student> implements StudentService {

}
