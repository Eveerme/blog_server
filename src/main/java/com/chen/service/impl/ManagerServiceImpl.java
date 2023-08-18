package com.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.dao.ManagerDAO;
import com.chen.pojo.dto.UserDTO;
import com.chen.pojo.po.Manager;
import com.chen.service.ManagerService;
import org.springframework.stereotype.Service;

/**
 * @Author chenyingtao
 * @Date 2023/8/3 11:21
 */

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerDAO, Manager> implements ManagerService {

    @Override
    public UserDTO getManagerInfoById() {
        return null;
    }
}
