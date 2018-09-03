package com.xm.config;

import com.xm.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index").setViewName("index");
                registry.addViewController("/logupPage").setViewName("logup");
                registry.addViewController("/loginPage").setViewName("login");
                registry.addViewController("/col_index").setViewName("col_index");
                registry.addViewController("/col_jiaotong").setViewName("col_jiaotong");
                registry.addViewController("/col_sheshi").setViewName("col_sheshi");
//                registry.addViewController("/col_zhuanye").setViewName("col_zhuanye");
                registry.addViewController("/col_zhusu").setViewName("col_zhusu");
                registry.addViewController("/com_index").setViewName("com_index");
                registry.addViewController("/stu_index").setViewName("stu_index");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //拦截除了登录界面之外的所有界面，如果未登陆的话
                //springboot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index","/login.html","/druid/*","/logupPage","/loginPage","/login","/logup");

            }
        };
    }
}
