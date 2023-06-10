package com.lsh.communityservice.conf;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/11 1:05
 * @Version 1.0
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("请求地址：" + requestURL);
        Object user = session.getAttribute("user");
        if (requestURL.toString().contains("login")) {
            return true;
        }
        if (null != user) {
            return true;

        }

//        session.setAttribute("preUrl",request.getRequestURI());

//        StringBuffer url = request.getRequestURL();
//        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length())
//                .append(request.getServletContext().getContextPath()).append("/").toString();

        response.sendRedirect("/toPage/login");

        return false;
    }
}
