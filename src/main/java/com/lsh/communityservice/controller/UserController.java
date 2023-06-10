package com.lsh.communityservice.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsh.communityservice.entry.User;
import com.lsh.communityservice.service.UserService;
import com.lsh.communityservice.vo.BaseController;
import com.lsh.communityservice.vo.Result;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/10 0:33
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Result login(HttpServletRequest request, HttpSession session,String username, String password, String captcha,Integer userType) {

        if (StrUtil.isBlank(username) || StrUtil.isBlank(password) || StrUtil.isBlank(captcha)) {
            return failure("用户名，密码，验证码不能为空！！！");
        }
        boolean ver = CaptchaUtil.ver(captcha, request);
        if (!ver) {
            return failure("验证码错误！！！");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,username).eq(User::getPassword,password).eq(User::getUsertype,userType);
        User one = userService.getOne(wrapper);
        if (ObjectUtil.isEmpty(one)) {
            return failure("用户名或者密码错误！！！");
        }
        one.setPassword(null);
        session.setAttribute("user",one);
        return success("登录成功！！！");
    }

}
