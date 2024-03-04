package com.example.userdemo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.userdemo.sys.entity.User;
import com.example.userdemo.sys.service.impl.UserServiceImpl;
import com.example.userdemo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yao
 * @since 2024-03-04
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    //查找全部
    @GetMapping("/find")
    public Result<List<User>> findUser() {
        List<User> users = userService.list(null);

        return Result.success(users);
    }


    //按条件查找
    @GetMapping("/list")
    public Result<Map<String, Object>> getUserList(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "avatar", required = false) String avatar,

            @RequestParam(value = "pageNo") long pageNo,
            @RequestParam(value = "pageSize") long pageSize) {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 添加查询条件
        wrapper
                .eq(StringUtils.hasLength(username), User::getUsername, username)
                .eq(StringUtils.hasLength(password), User::getPassword, password)
                .eq(User::getEmail, email)
                .eq(User::getPhone, phone)
                .eq(User::getAvatar, avatar);


        // 执行查询
        IPage<User> page = new Page<>(pageNo, pageSize);
        IPage<User> result = userService.page(page, wrapper);

        // 返回查询结果
        Map<String, Object> data = new HashMap<>();
        data.put("total", result.getTotal());
        data.put("records", result.getRecords());


        if (data != null) {
            return Result.success(data);
        } else return Result.fail();
    }

    //删除
    @DeleteMapping("/{id}")
    public Result<?> deleteUser(@PathVariable("id") Integer id) {
        userService.removeById(id);
        return Result.success();
    }




   //新增
    @PostMapping
    public Result<String> addUser(@RequestBody User user) {
        userService.save(user);
        String result = "新增用户成功";
        return Result.success(result);
    }




//修改
    @PutMapping
    public Result<String> updateUser(@RequestBody User user){
        userService.updateById(user);
        String mes="修改成功";
        return  Result.success(mes);
    }
}



