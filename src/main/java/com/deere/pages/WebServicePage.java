package com.deere.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.deere.global.InputTestDetails;
import com.deere.utility.okta.OktaUtility;

import junit.framework.Assert;

public class WebServicePage {

	public static String MAINTAINQUOTEWS = "MaintainQuoteWS";
	public static String QUOTEDATAWS = "QuoteDataWs";
	public static String PODATAWS = "PODataWS";
	public static String JDSCWS = "JDSCWS";
	public static String APPID = "A79DSDP";
	public static String CERTTOKEN = "CERTTOKEN";
	public static String QUALTOKEN = "QUALTOKEN";
	public static String PRODTOKEN = "PRODTOKEN";
	public static String TokenBeanName = "clientCredentialsOAuth2RestTemplate";

	@SuppressWarnings("deprecation")
	@Test
	public void getSoapResponse(InputTestDetails inputTestDetails)
			throws ClientProtocolException, IOException, IllegalArgumentException, InterruptedException {
		String endpoint = inputTestDetails.getTestdata()[0].toString();
		String reqFilePath = inputTestDetails.getTestdata()[1].toString();
		String responseFilePath = inputTestDetails.getTestdata()[2].toString();
		String env = inputTestDetails.getTestdata()[4].toString();
		String wsName = inputTestDetails.getTestdata()[5].toString();
		File requestFile = new File(System.getProperty("user.dir") + reqFilePath);
		String getAppName = getAppName(env);
		Thread.sleep(5000);
		String token = OktaUtility.generateAuthToken(TokenBeanName, getAppName, env);
		Thread.sleep(5000);
		System.out.println(token);
		HttpClient cilent = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-type", "text/xml");
		post.setHeader("Authorization", token);
		if (QUOTEDATAWS.equalsIgnoreCase(wsName)) {
			post.setHeader("ApplicationId", APPID);// Providing JDSET AppID in
													// header
		}
		HttpResponse response = cilent.execute(post);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + responseFilePath);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getRestResponseForGetRequests(InputTestDetails inputTestDetails)
			throws ClientProtocolException, IOException, InterruptedException {
		String endpoint = inputTestDetails.getTestdata()[0].toString();
		String responseFilePath = inputTestDetails.getTestdata()[1].toString();
		String env = inputTestDetails.getTestdata()[2].toString();
		String wsName = inputTestDetails.getTestdata()[3].toString();
		String getAppName = getAppName(env);
		Thread.sleep(5000);
		String token = OktaUtility.generateAuthToken(TokenBeanName, getAppName, env);
		Thread.sleep(5000);
		System.out.println(token);
		HttpClient cilent = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(endpoint);
		get.setHeader("Content-type", "application/json");
		get.setHeader("Accept", "application/json");
		get.setHeader("Authorization", token);
		if (QUOTEDATAWS.equalsIgnoreCase(wsName)) {
			get.setHeader("ApplicationId", APPID);// Providing JDSET AppID in
													// header
		}
		HttpResponse response = cilent.execute(get);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(System.getProperty("user.dir") + responseFilePath);
		PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + responseFilePath);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getRestResponseForPOSTRequests(InputTestDetails inputTestDetails)
			throws ClientProtocolException, IOException, InterruptedException {
		String endpoint = inputTestDetails.getTestdata()[0].toString();
		String responseFilePath = inputTestDetails.getTestdata()[1].toString();
		String env = inputTestDetails.getTestdata()[2].toString();
		String wsName = inputTestDetails.getTestdata()[3].toString();
		String requestFilePath = inputTestDetails.getTestdata()[4].toString();
		File requestFile = new File(System.getProperty("user.dir") + requestFilePath);
		String getAppName = getAppName(env);
		Thread.sleep(5000);
		String token = OktaUtility.generateAuthToken(TokenBeanName, getAppName, env);
		Thread.sleep(5000);
		System.out.println(token);
		HttpClient cilent = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-type", "application/json");
		post.setHeader("Accept", "application/json");
		post.setHeader("Authorization", token);
		if (QUOTEDATAWS.equalsIgnoreCase(wsName)) {
			post.setHeader("ApplicationId", APPID);// Providing JDSET AppID in
													// header
		}
		HttpResponse response = cilent.execute(post);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(System.getProperty("user.dir") + responseFilePath);
		PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + responseFilePath);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	}

	@SuppressWarnings("deprecation")
	public void readResponse(InputTestDetails inputTestDetails)
			throws SAXException, IOException, ParserConfigurationException {
		String responseFilePath = inputTestDetails.getTestdata()[2].toString();
		String tagName = inputTestDetails.getTestdata()[3].toString();
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		// Build Document
		Document document = builder.parse(new File(System.getProperty("user.dir") + responseFilePath));
		// Normalize the XML Structure;
		document.getDocumentElement().normalize();
		System.out.println(document.getDocumentElement().getNodeName());
		NodeList nodeList = document.getElementsByTagName(tagName);
		int tLength = nodeList.getLength();
		System.out.println(tLength);

		for (int i = 0; i < tLength; i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (element.getElementsByTagName("errorMessage").item(0) != null) {
					String actualMessage = element.getElementsByTagName("errorMessage").item(0).getTextContent();
					System.out.println("Error Message: " + actualMessage);
					Assert.assertEquals("", actualMessage);
				}
				break;
			}
		}

	}

	public static String getAppName(String env) throws IllegalArgumentException {
		switch (env) {
		case "cert":
			return CERTTOKEN;
		case "qual":
			return QUALTOKEN;
		case "prod":
			return PRODTOKEN;
		default:
			throw new IllegalArgumentException("Provide valid env like cert,prod or qual");
		}
	}

	@SuppressWarnings("deprecation")
	public void readJsonRespons(InputTestDetails inputTestDetails) {
		String responseFilePath = inputTestDetails.getTestdata()[1].toString();
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(System.getProperty("user.dir") + responseFilePath)) {
			// Parse JSON file
			Object obj = jsonParser.parse(reader);
			JSONObject jsonResponse = (JSONObject) obj;
			JSONObject responseBody = (JSONObject) jsonResponse.get("body");
			String errorMessage = (String) responseBody.get("errorMessage");
			Assert.assertEquals(null, errorMessage);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
