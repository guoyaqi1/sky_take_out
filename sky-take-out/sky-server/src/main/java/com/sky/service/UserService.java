package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.vo.UserLoginVO;

/**
 * @Author:guoyaqi
 * @Date: 2024/11/3 14:50
 */

public interface UserService {

    User wxlogin(UserLoginDTO userLoginDto);
}
