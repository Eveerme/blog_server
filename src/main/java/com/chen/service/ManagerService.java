package com.chen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.dto.UserDTO;
import com.chen.pojo.po.Manager;

public interface ManagerService extends IService<Manager> {
    UserDTO getManagerInfoById();
}
