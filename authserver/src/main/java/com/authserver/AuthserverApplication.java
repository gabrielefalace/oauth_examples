package com.authserver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@SpringBootApplication
@EnableAuthorizationServer
public class AuthserverApplication extends AuthorizationServerConfigurerAdapter {

	@Autowired
	AuthenticationManager manager;
	
	@Bean
	public TokenStore tokenStore() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		DataSource dataSource = builder.setType(EmbeddedDatabaseType.H2)
				.build();
		return new JdbcTokenStore(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		endpoints.tokenStore(tokenStore());
		endpoints.authenticationManager(manager);	// needed to use the "password" grant_type ... 
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		clients.inMemory()
			.withClient("acme")
			.secret("acmesecret")			
			.scopes("read", "write")
			.autoApprove(".*")
			.authorizedGrantTypes("client_credentials")
		.and()
			.withClient("donald")
			.secret("duck")
			.scopes("read","write")
			.autoApprove(".*")
			.authorizedGrantTypes("password", "refresh_token");
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
	}

}