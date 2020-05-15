package com.deere.utility.okta;


import java.util.HashMap;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.deere.utility.okta.OAuth2ClientConfig;

public class OktaUtility {
   private static HashMap<String, OAuth2AccessToken> tokens = new HashMap<String, OAuth2AccessToken>();
	private static final String SPACE = " ";
	/**
	 * This method will call the authorization server and will return the 
	 * access token to get into the other application
	 * @param bean
	 * @return String
	 */
	 public static String generateAuthToken(String bean, String appName,String env) {

		OAuth2AccessToken authToken = tokens.get(appName);

		if(authToken!=null && !authToken.isExpired()) {

			return createBearerToken(authToken);
		}
		OAuth2AccessToken accessToken = null;
		OAuth2ClientConfig.serPropertyBasedOnEnvironment(env);
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(OAuth2ClientConfig.class);
		try{
		OAuth2RestOperations oauth2RestTemplateForOrderJAXWS = (OAuth2RestOperations) applicationContext.getBean(bean);
		accessToken = oauth2RestTemplateForOrderJAXWS.getAccessToken();
		} catch (Exception e){
			e.printStackTrace();
		}

		tokens.put(appName, accessToken);

		return createBearerToken(accessToken);

	}

	private static String createBearerToken(OAuth2AccessToken authToken) {
		return authToken.getTokenType() + SPACE + authToken.getValue();
	}	

	
	public static boolean isTokenTimedOut(String appName) {

		OAuth2AccessToken authToken = tokens.get(appName);

		return (authToken!=null && authToken.isExpired());
	}
}

