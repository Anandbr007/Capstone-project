package com.himalaya.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class handles reading properties from configuration files.
 */
public class FileIO {
	
	/** The properties object to store the loaded properties. */
	private static Properties properties;
	
	/**
	 * Gets the properties from the configuration file.
	 *
	 * @return the properties object containing the loaded properties
	 */
	public static Properties getProperties(){
		// Check if properties object is null
		if(properties==null){
			properties = new Properties();
			try {
				// Load properties from the configuration file
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\objectrepository\\configuration.properties");
				properties.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}





