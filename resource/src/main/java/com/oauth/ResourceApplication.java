package com.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourceApplication {

	@Bean
	public ResourceServerTokenServices tokenService() {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setClientId("donald");
		tokenServices.setClientSecret("duck");
		tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
		return tokenServices;
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
}
