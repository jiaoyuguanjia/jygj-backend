package com.jygj.admin.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

public class ResourceUtils {
	
	public static Properties getProperties(String propFile) {
		try {
			InputStream fis = new FileInputStream(new File(
					getResourcePath(propFile)));

			Properties properties = new Properties();
			properties.load(fis);

			fis.close();
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static String getResourcePath(String fileName) {
		try {
			return URLDecoder.decode(Thread.currentThread()
					.getContextClassLoader().getResource(fileName).getPath(),
					"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String getEnvConfig() {
		return getProperties("hibernate.properties").getProperty("env.config");
	}

	public static String getProdCfgXml() {
		return getResourcePath("hibernate.cfg.prod.xml");
	}
	
	public static boolean isProdEnvConfig() {
		return EnvConfig.PROD.toString().equalsIgnoreCase(getEnvConfig());
	}
}
