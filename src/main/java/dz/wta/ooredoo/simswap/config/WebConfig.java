package dz.wta.ooredoo.simswap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dz.wta.ooredoo.simswap.filter.CustomFilter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final long MAX_AGE = 3600;

	@Autowired
	CustomFilter customFilter;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*")
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").maxAge(MAX_AGE)
				.allowCredentials(true);
	}

	// uncomment this and comment the @Component in the filter class definition to
	// register only for a url pattern
	@Bean
	public FilterRegistrationBean<CustomFilter> loggingFilter() {
		FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(customFilter);
		registrationBean.addUrlPatterns("/api/*");

		return registrationBean;

	}

}
