package com.chen.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author chenyingtao
 * @Date 2023/8/18 13:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_courses")
public class Courses implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;
    /**
     * 课程名
     */
    @TableField("course_name")
    private String courseName;
    /**
     * 创建人的用户id
     */
    @TableField("create_by")
    private Long createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;
}
