package com.example.userdemo.sys.service.impl;

import com.example.userdemo.sys.entity.User;
import com.example.userdemo.sys.mapper.UserMapper;
import com.example.userdemo.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2024-03-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
