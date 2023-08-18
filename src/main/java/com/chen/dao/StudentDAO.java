package com.chen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.po.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDAO extends BaseMapper<Student> {

}
