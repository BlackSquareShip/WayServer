package ru.wayproj.wayserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.wayproj.wayserver.services.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsServise;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServise);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/auth/login")
//                .defaultSuccessUrl("http://localhost:3000/", true)
//                .failureUrl("http://localhost:3000/");
//
//        http.cors().and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .csrf().ignoringAntMatchers("/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers(/*permission*/).hasAnyRole()
//                .antMatchers("/auth/login","/auth/loginClient","/auth/loginSudo")
//                .authenticated()
//                .and()
//                .httpBasic();

        http.authorizeRequests()
                .antMatchers("/auth/login", "error", "/auth/registration").permitAll()
                .anyRequest().authenticated().and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
