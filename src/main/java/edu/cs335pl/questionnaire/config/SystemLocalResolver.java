package edu.cs335pl.questionnaire.config;


import com.mysql.cj.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class SystemLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!!!!!!!!!页面没写！！！！！！！！！！！！！！！！！！！！！
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(StringUtils.isNullOrEmpty(language)){
             String[] split = language.split("_");
             locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
