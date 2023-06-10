package com.lsh.communityservice.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lsh.communityservice.entry.User;
import com.lsh.communityservice.vo.Result;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/10 1:13
 * @Version 1.0
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(HttpSession session) {
        Object user = session.getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            return "login";
        } else {
            return "index";
        }
    }


    @RequestMapping("user/out")
    public String out(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("toPage/{page}")
    public String toPage(@PathVariable("page") String page) {
        return page;
    }



}
