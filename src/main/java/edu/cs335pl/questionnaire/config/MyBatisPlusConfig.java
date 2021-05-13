package edu.cs335pl.questionnaire.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //配置类,必须要有这个注解
@EnableTransactionManagement //启动事务
@MapperScan("edu.cs335pl.questionnaire.mapper") //扫描我们的mapper文件夹
public class MyBatisPlusConfig {
    //注册乐观锁插件
    @Bean //3.4.0已经不这样了，看官网
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){ return new PaginationInterceptor(); }

    //逻辑删除组件，高版本不需要了
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
