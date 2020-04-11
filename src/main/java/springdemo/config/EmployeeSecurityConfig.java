package springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {


    private final DataSource securityDataSource;

    @Autowired
    public EmployeeSecurityConfig(DataSource securityDataSource){
        this.securityDataSource = securityDataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/employee").hasAnyRole("EMPLOYEE", "MANAGER")
            .antMatchers("/settings/**").hasRole("ADMIN")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/defaultUserPage")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
            .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied");
    }

}
