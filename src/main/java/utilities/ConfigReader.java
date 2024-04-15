package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
  private final Properties properties;

  public ConfigReader(String configFilePath) {
    properties = new Properties();
    try (InputStream input = new FileInputStream(configFilePath)) {
      // Load the properties file
      properties.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

}