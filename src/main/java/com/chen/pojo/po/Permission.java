package com.chen.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author chenyingtao
 * @Date 2023/8/18 13:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role_menu")
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;
    /**
     * 角色编号
     */
    @TableField("role_id")
    private String roleId;
    /**
     * 菜单编号
     */
    @TableField("menu_id")
    private String menuId;
}
