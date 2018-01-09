package com.iat.epoints.ingestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.iat.epoints.ingestservice")
public class Application extends SpringBootServletInitializer {

	private static final Class<Application> APPLICATION_CLASS = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(APPLICATION_CLASS, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder APPLICATION_CLASS) {
		return super.configure(APPLICATION_CLASS);
	}

	// @Bean
	// ServletRegistrationBean servletRegistrationBean() {
	// ServletRegistrationBean servlet = new ServletRegistrationBean(new
	// CamelHttpTransportServlet(),
	// contextPath + "/*");
	// servlet.setName("CamelServlet");
	// return servlet;
	// }
}
