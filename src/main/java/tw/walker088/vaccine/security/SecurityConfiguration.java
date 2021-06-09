package tw.walker088.vaccine.security;
/*
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
*/
public class SecurityConfiguration /* extends WebSecurityConfigurerAdapter */ {
    /*
    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.debug("SecurityConfiguration.configure(HttpSecurity)");
        http
            .authorizeRequests()
            .antMatchers( "/public/**").permitAll()
            .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login.html")
                .failureUrl("/login-error.html")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.debug("SecurityConfiguration.configure(AuthenticationManagerBuilder)");
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}pass") // Spring Security 5 requires specifying the password storage format
            .roles("USER");
    }
    */
}