package com.lsh.communityservice.service.impl;

import com.lsh.communityservice.entry.User;
import com.lsh.communityservice.mapper.UserMapper;
import com.lsh.communityservice.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
* User接口实现层
*
* @author lushao
* @version 1.0.0 2023-06-10 01:06:43
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}