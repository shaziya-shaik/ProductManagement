package com.Telusko.ProductSpringWeb.WebConfig;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
public class WebConfig {
	 public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**") // Allow all endpoints
         .allowedOrigins("http://localhost:4200") // Allow requests from your Angular app
         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed methods
         .allowedHeaders("*") // Allow all headers
         .allowCredentials(true); // If you need to include credentials
	    }
}
