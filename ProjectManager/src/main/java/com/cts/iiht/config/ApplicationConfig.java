package com.cts.iiht.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cts.iiht.model.*;


@Configuration
@ImportResource({"classpath*:beans.xml"})
@ComponentScan("com.cts.iiht") 
@EnableWebMvc 
public class ApplicationConfig extends WebMvcConfigurerAdapter {  
  /*  @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true);
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }*/


	@Bean
	public Project project() {
		return new Project();
	}
	
	@Bean
	public Task task() {
		return new Task();
	}
	
	@Bean
	public ParentTask parentTask() {
		return new ParentTask();
	}
}
