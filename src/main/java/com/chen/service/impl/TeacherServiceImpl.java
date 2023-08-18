package com.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.TeacherDAO;
import com.chen.pojo.po.Teacher;
import com.chen.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @Author chenyingtao
 * @Date 2023/8/3 11:21
 */

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDAO, Teacher> implements TeacherService {

}
