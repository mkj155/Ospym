package com.osdepym.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan({"com.osdepym.hibernate.dao","com.osdepym.controller","com.osdepym.hibernate.entity","com.osdepym.service","com.osdepym.validator"})
@Configuration
@EnableTransactionManagement
@ImportResource("classpath:spring.xml")
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
        
    
    @Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    	messageSource.setBasename("messages");
    	return messageSource;
    }
    
    @Bean
    public LocaleResolver localeResolver() {
       CookieLocaleResolver localeResolver = new CookieLocaleResolver();
       return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
       themeChangeInterceptor.setParamName("theme");
       registry.addInterceptor(themeChangeInterceptor);

       LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
       localeChangeInterceptor.setParamName("language");
       registry.addInterceptor(localeChangeInterceptor);
    }
}
