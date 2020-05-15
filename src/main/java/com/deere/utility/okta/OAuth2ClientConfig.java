package com.deere.utility.okta;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class OAuth2ClientConfig {
	
	public static Properties prop = new Properties();
	
	@Bean
	public OAuth2RestOperations clientCredentialsOAuth2RestTemplate() {
		return new OAuth2RestTemplate(clientCredentialsDetailsForOauth2Token());
	}

	@Bean
	public ClientCredentialsResourceDetails clientCredentialsDetailsForOauth2Token() {

		ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
		clientCredentialsResourceDetails.setId("1");
		clientCredentialsResourceDetails.setClientId(prop.getProperty("jdquote.clientId"));
		clientCredentialsResourceDetails.setClientSecret(prop.getProperty("jdquote.clientSecret"));
		clientCredentialsResourceDetails.setAccessTokenUri(prop.getProperty("jdquote.tokenUri"));
		String scopes = prop.getProperty("jdquote.scope");
		List<String> scopeList = Arrays.asList(scopes.split(" "));
		clientCredentialsResourceDetails.setScope(scopeList);
		return clientCredentialsResourceDetails;
	}
	
	public static void serPropertyBasedOnEnvironment(String env){
		String currentPath =System.getProperty("user.dir");
		String path = currentPath+"/src/main/java/config/okta-"+env+"-config.properties";
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}