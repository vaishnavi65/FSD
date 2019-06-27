package com.cts.iiht.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cts.iiht.model.AllTaskDetails;
import com.cts.iiht.model.ParentTask;
import com.cts.iiht.model.Project;
import com.cts.iiht.model.Task;
import com.cts.iiht.model.Users;


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
	
	@Bean
	public Users user() {
		return new Users();
	}
	
	@Bean
	public AllTaskDetails taskDetails()
	{
		return new AllTaskDetails();
	}
	
	
}
