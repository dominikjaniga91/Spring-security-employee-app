package springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {


    private final DataSource securityDataSource;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeSecurityConfig(DataSource securityDataSource, PasswordEncoder passwordEncoder){
        this.securityDataSource = securityDataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Dominik").password(passwordEncoder.encode("dominik123")).roles("ADMIN").and()
                .withUser("Daria").password(passwordEncoder.encode("daria123")).roles("EMPLOYEE").and()
                .withUser("Maciek").password(passwordEncoder.encode("bankier")).roles("MANAGER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/employee").hasAnyRole("EMPLOYEE", "MANAGER")
            .antMatchers("/settings/**").hasRole("ADMIN")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .anyRequest().authenticated()
            .and().httpBasic()
            .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/control-panel")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
            .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
            .and()
                .rememberMe()
                .key("remember-me")
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("rememberlogin")
                .tokenValiditySeconds(100);
    }

}
