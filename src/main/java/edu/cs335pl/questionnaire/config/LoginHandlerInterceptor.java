package edu.cs335pl.questionnaire.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","Access denied -- Please Login");
            //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
            //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
            //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
            //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{

    }
}
