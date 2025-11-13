
package com.parameters;
 
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;
 
public class PropertyReader {
 
    private static Properties prop = new Properties();
 
    public static Properties readProperty() {

        String fileName = "src\\test\\resources\\com\\Properties\\profile.properties";

        try {

            FileInputStream fis = new FileInputStream(fileName);

            prop.load(fis);

        } catch (FileNotFoundException e) {

            System.out.println("File name or file path is not correct");

        } catch (IOException e) {

            e.printStackTrace();

        }

        return prop;

    }
 
    // Method to get property value by key

    public static String get(String key) {

        return prop.getProperty(key);

    }

}
 

