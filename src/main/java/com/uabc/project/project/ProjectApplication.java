package com.uabc.project.project;

import com.uabc.project.project.model.security.UserSecurity;
import com.uabc.project.project.repository.security.UserRepositorySecurity;
import com.uabc.project.project.services.security.UserServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ProjectApplication {

    @Autowired
    UserRepositorySecurity userRepositorySecurity;
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            userRepositorySecurity.save(new UserSecurity("jose","jose123"));
            userRepositorySecurity.save(new UserSecurity("rosendo","rosendo123"));
            userRepositorySecurity.save(new UserSecurity("admin","password"));

        };
    }
    @Configuration
    protected static class AuthenticationSecurity extends
            GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private UserServiceImpl users;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(users);
        }
    }
}
