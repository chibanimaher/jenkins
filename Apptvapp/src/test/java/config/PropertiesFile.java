package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	static Properties prop=new Properties();
	static String path=System.getProperty("user.dir");
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
            getProperties();
            setProperties();
            getProperties();
	}

	public static void getProperties() throws Exception {
	
		try {
			
			
			System.out.println(path);
			InputStream input =new FileInputStream(path+"\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
		} catch (FileNotFoundException e) {
			System.out.println (e.getMessage());
			System.out.println(e.getCause());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setProperties() {
		try {
			OutputStream output= new FileOutputStream(path+"\\src\\test\\java\\config\\config.properties");	
		prop.setProperty("browser", "chrome");
		prop.store(output, null);
		} catch (Exception e) {
			System.out.println (e.getMessage());
			System.out.println(e.getCause());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				}
}
