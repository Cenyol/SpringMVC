package com.cenyol.mybatisplus.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 2019-09-23 20:23
 */
@Configuration
@EnableTransactionManagement
@MapperScan( value = {"com.cenyol.mybatisplus.api.mapper"} )
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

