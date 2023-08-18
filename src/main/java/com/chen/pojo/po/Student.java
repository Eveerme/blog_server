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
 * @Date 2023/8/16 16:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户名
     */
    @TableField("stu_name")
    private String stuName;
    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    @TableField("status")
    private String status;
    /**
     * 用户性别（0男，1女，2未知）
     */
    @TableField("sex")
    private String sex;
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
