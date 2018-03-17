package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties properties;
	static{
		try {
			properties = new Properties();
			String property = "./test1.properties";
			FileInputStream inputStream = new FileInputStream(property);
			properties.load(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}

}
