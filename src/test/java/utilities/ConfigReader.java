package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
		private Properties properties;
		FileInputStream fis;

		public ConfigReader() throws IOException {
			properties = new Properties();
			this.fis = new FileInputStream("src/test/resources/config/config.properties");
			properties.load(fis);

		}

		public String getProperty(String key) {
			return properties.getProperty(key);
			 
		}

	}


