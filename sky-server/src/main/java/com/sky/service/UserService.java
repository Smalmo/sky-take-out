package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @author Zhou
 * @creat 2024-05-27 15:35
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    User weChatLogin(UserLoginDTO userLoginDTO);
}
