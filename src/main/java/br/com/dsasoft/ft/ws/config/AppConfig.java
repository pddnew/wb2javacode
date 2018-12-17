package br.com.dsasoft.ft.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

	@Value("${app.version}")
	private String appVersion;
	
	
	@Value("${mongodb.user}")
	private String mongoUser;

	@Value("${mongodb.pass}")
	private String mongoPass;
	
	@Value("${mongodb.url}")
	private String url;
	
	public String getAppVersion() {
		return appVersion;
	}

	public String getMongoUser() {
		return mongoUser;
	}

	public String getMongoPass() {
		return mongoPass;
	}

	public String getUrl() {
		return url;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
