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
 * @Date 2023/8/18 13:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_exams")
public class Exams implements Serializable {
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;
    /**
     * 考试名
     */
    @TableField("exam_name")
    private String examName;
    /**
     * 考试科目
     */
    @TableField("course_ids")
    private String courseIds;
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
