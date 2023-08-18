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
 * @Date 2023/8/18 13:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_marks")
public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;
    /**
     * 学生编号
     */
    @TableField("stu_id")
    private String stuId;
    /**
     * 成绩
     */
    @TableField("grades")
    private String grades;
    /**
     * 考试编号
     */
    @TableField("exams_id")
    private String examsId;
    /**
     * 课程编号
     */
    @TableField("course_id")
    private String courseId;
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
