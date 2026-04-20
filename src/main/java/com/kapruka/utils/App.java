package com.kapruka.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {
	private static final String filePath = "./src/main/resources/app.properties";

	private App() {
		// TODO Auto-generated constructor stub
	}
	public static String getProperty(String filePath, String key) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		String value = null;
		Properties prop = new Properties();
		prop.load(fis);
		value = prop.getProperty(key);
		return value;
	}	

	public static String getBrowserName() {
		String browserName = null;
		try {
			browserName = getProperty(filePath, "browser_name");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return browserName;
	}
	
	public static String getUrl(String env) {
		String appUrl = null;
		try {
			appUrl = getProperty(filePath, "app_" + env + "url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appUrl;
	}
	
	public static String getUserName(String env) {
		String userName = null;
		try {
			userName = getProperty(filePath, "app_" + env + "UserName");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userName;		
	}
	
	public static String getPassword(String env) {
		String password = null;
		try {
			password = getProperty(filePath, "app_" + env + "Password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;		
	}

	
}
