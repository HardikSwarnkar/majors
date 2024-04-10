package config;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PropertiesFile {

	static Properties prop=new Properties();
	static String projectPath=System.getProperty("user.dir");


	public static void main(String[] args) {
		getProperties();
		setProperties();
		
	}

	public static void getProperties() {
		try {


			InputStream input= new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser=prop.getProperty("browser");
			System.out.println(browser);

		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
		}
	}


	public static void setProperties() {
		try {
			OutputStream output=new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			prop.setProperty("browser", "egde");
			prop.store(output,null);
			
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
		}
	}
}
