package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	Properties properties;
	String path = ".\\src\\test\\resources\\Config.Properties";
	
	public ConfigReader() throws Exception
	{
		properties = new Properties();
		try(FileInputStream fileinputstream = new FileInputStream(path);)
		{
			properties.load(fileinputstream);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("File Loading Failed...");
		}	
	}
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	public int getIntProperty(String key)
	{
		return Integer.parseInt(getProperty(key));
	}

}
