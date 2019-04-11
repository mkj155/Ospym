package com.osdepym.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.osdepym.dto.StringToHijo;
import com.osdepym.service.ContactoService;
import com.osdepym.service.ContactoServiceImpl;
import com.osdepym.service.TestServiceImpl;

import com.osdepym.configuration.ConfigurationEnviroment;

@EnableWebMvc
@ComponentScan({"com.osdepym.hibernate.dao","com.osdepym.controller","com.osdepym.hibernate.entity","com.osdepym.service"})
@Configuration
@EnableTransactionManagement
@ImportResource("classpath:spring.xml")
public class ConfiguracionSpring  extends WebMvcConfigurerAdapter {
	
//	@Autowired
//	@Qualifier("ContactService")
//	ContactoService service;
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		ConfigurationEnviroment.getInstance().getContext();
    }
	
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setViewClass(JstlView.class);
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
    }
        
    
//    @Bean
//    public MessageSource messageSource() {
//    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//    	messageSource.setBasename("messages");
//    	return messageSource;
//    }
    
    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(new StringToHijo());
    }
    
}

