package com.smile.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author gaowenjin
 * @date 2021/1/6
 * @description:
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 跨域
        http.cors().and().csrf().disable();

        http.authorizeRequests().anyRequest().authenticated()
                // 设置登陆页
                .and().formLogin().loginPage("/login").permitAll()
                // 设置登陆成功页
                .defaultSuccessUrl("/index");
        // 页面可以在相同域名页面的frame中展示
        http.headers().frameOptions().sameOrigin();

//        http.formLogin().usernameParameter("").passwordParameter("");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码 强哈希方法
        return new BCryptPasswordEncoder();
    }

}
