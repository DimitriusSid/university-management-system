package com.loria_university.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Configuration
@ComponentScan("com.loria_university")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("org.postgresql.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/loria_university?useSSL=false");
            comboPooledDataSource.setUser("postgres");
            comboPooledDataSource.setPassword("postgre");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com.loria_university.entity");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean
    public TransactionManager transactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }

    @Bean
    public SimpleFormatter simpleFormatter() {
        return new SimpleFormatter();
    }

    @Bean
    public Handler handler() {
        Handler handler = null;
        try {
            handler = new FileHandler("C:/Users/user/IdeaProjects/loria_university/app_log.log", true);
            handler.setFormatter(simpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handler;
    }

    @Bean
    Logger logger() {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.addHandler(handler());
        return logger;
    }


}
