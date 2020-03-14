package com.cidp.aoplog.config.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("test").roles("user").password("$2a$10$V0VWQ4I0Hr/Z2Be2veQh3emu2fbl9eH80RK7wuGEkR7BeDORutiSa")
                .and().withUser("zdde").roles("admin").password("$2a$10$V0VWQ4I0Hr/Z2Be2veQh3emu2fbl9eH80RK7wuGEkR7BeDORutiSa");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin() //表单登录配置
                .loginProcessingUrl("/login")//表单登陆提交数据的路径
                .and()
                .csrf().disable();
    }
}
