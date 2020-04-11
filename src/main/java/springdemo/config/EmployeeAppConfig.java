package springdemo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "springdemo")
@PropertySource("classpath:persistance.properties")
public class EmployeeAppConfig {

    @Autowired
    private Environment environment;
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try{
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        }catch (PropertyVetoException ex){
            ex.printStackTrace();
        }

        logger.info("jdbc url = " + environment.getProperty("jdbc.url"));
        logger.info("jdbc user = " + environment.getProperty("jdbc.user"));

        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        securityDataSource.setInitialPoolSize(
                parsePropertyToInt("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(
                parsePropertyToInt("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(
                parsePropertyToInt("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(
                parsePropertyToInt("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int parsePropertyToInt(String property){
        String propertyValue = Objects.requireNonNullElse(environment.getProperty(property), "100");
        return Integer.parseInt(propertyValue);
    }
}
