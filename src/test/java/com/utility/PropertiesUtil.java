package com.utility;

import java.io.*;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
 //Read properties file
	
	public static String readProperty(Env env, String propertyName){
		System.out.println(System.getProperty("user.dir") + "\\config\\" + "QA.properties");
		File propFile = new File(System.getProperty("user.dir") + "\\config\\" + env +".properties");
		FileReader fileReader;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}	
		
		return properties.getProperty(propertyName.toUpperCase());
	}
}
