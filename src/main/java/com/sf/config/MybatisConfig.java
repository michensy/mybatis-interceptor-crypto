package com.sf.config;

import com.sf.interceptor.CryptInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zidong
 * @date 2019/5/9 10:07 AM
 */
@Configuration
public class MybatisConfig {

    @Bean
    public CryptInterceptor cryptInterceptor() {
        return new CryptInterceptor();
    }
}
