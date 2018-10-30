package com.needayeah.elasticsearch.config;

import com.needayeah.elasticsearch.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    /**
     * HTTP 权限控制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //资源访问权限
        http.authorizeRequests()
            .antMatchers("/admin/login").permitAll()//管理员登录入口
            .antMatchers("/static/**").permitAll()//静态资源
            .antMatchers("/user/login").permitAll()//用户登录入口
            .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin()
                .loginPage("/login") //配置角色登录处理入口
                .and();

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义认证策略
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 从内存配置认证信息
        /*auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").and();*/
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }
}
