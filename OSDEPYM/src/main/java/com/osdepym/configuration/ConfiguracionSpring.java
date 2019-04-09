package com.osdepym.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
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
@ComponentScan("com.osdepym.controller")
@Configuration
public class ConfiguracionSpring  extends WebMvcConfigurerAdapter {
	
    
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
    
    
    // this bean will be injected into the OrderServiceTest class
    @Bean
    public ContactoService ContactoService() {
    	ContactoService contactoService = new ContactoServiceImpl();
        // set properties, etc.
        return contactoService;
    }
    
    @Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    	messageSource.setBasename("messages");
    	return messageSource;
    }
    
    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(new StringToHijo());
    }
    
    
    
}

