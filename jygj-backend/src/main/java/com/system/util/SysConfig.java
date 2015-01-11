package com.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *  !禁止直接调用本类，所有去系统配置方法已经移入SysCahce 
 * @author Michael
 */
class SysConfig {
	private static final Logger logger = Logger.getLogger(SysConfig.class);
	public static final String GLOBAL = "global.properties";
	public static final String LOCAL_CONFIG = "config.properties";
	private static final String KEY_CONFIG_FILE_PATH = "config.file.path";
	private static final String KEY_USE_EXTERNAL="use.external.config";
	
	private static Properties prop;
	private static File configFile;
	private static long cachedLastModified;
	private static long checkLastModifiedDelay = 5000;

	static {
		initSysconfig();
	}
	
	public static void initSysconfig(){
		prop = new Properties();
		String configFilePath = null;
		FileInputStream configFileInputStream = null;
		try {
			logger.info("##### init config files #######");
			// load global config
			prop.load(SysConfig.class.getClassLoader().getResourceAsStream(GLOBAL));
			
			if("true".equals(getItem(KEY_USE_EXTERNAL))){
				// load external config
				configFilePath = getItem(KEY_CONFIG_FILE_PATH);
				if ( StringUtils.isNotBlank(configFilePath) ) {
					configFile = new File(configFilePath);
					if(configFile.exists()){
						cachedLastModified = configFile.lastModified();
						configFileInputStream = new FileInputStream(configFile);
						prop.load(configFileInputStream);
						logger.info("##### load outer config file complete #######");
					}else if(System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS")){
						//windows环境，允许读取本地配置文件
						logger.warn("####### Config file at "+configFilePath+" not exist, try local file #######");
						prop.load(SysConfig.class.getClassLoader().getResourceAsStream(LOCAL_CONFIG));
						logger.info("##### load local config file complete #######");
					}else{
						logger.error("!!!!!!!!!!!! config.properties at "+configFilePath +" not found !!!!!!!!!!!!");
					}
				} else {
					logger.error("!!!!!!!!! Do not set external config file, please set it on " + GLOBAL + "!!!!!!!!!!");
				}
			}else{
				logger.info("####### USE INTERNAL "+LOCAL_CONFIG+" ########");
				prop.load(SysConfig.class.getClassLoader().getResourceAsStream(LOCAL_CONFIG));
			}
			
		} catch (FileNotFoundException e) {
			logger.error("Can not find config file [" + configFilePath + "]!");
		}  catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if ( configFileInputStream != null ) {
				try {
					configFileInputStream.close();
					configFileInputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getItem(String key) {
		 String result =prop.getProperty(key.toLowerCase(), "");
		 if(StringUtils.isEmpty(result)){
			 result =prop.getProperty(key, "");
		 }		 
		 return result; 
	}
	
	public static Integer getInteger(String key) {
		String value = SysConfig.getItem(key);
		Integer result = null;
		if (value != null && value.length() > 0) {
			result = Integer.parseInt(value);
		}
		return result;
	}
	
	public static Boolean getBoolean(String key) {
		String value = SysConfig.getItem(key);
		Boolean result = false;
		if (value != null && value.length() > 0) {
			if(value.trim().equals("true")){
				result = true;
			}
		}
		return result;
	}

	public static synchronized boolean freshCacheRequired() {
		boolean freshCacheRequired = false;
		long current = System.currentTimeMillis();
		
		// have a little delay to reduce IO request
		if ( (current - cachedLastModified) > checkLastModifiedDelay ) {
			long lastModified = configFile.lastModified();
			
			// config file changed
			if ( lastModified > cachedLastModified ) {
				FileInputStream configFileInputStream = null;
				try {
					logger.info(configFile.getAbsolutePath() + "has been changed, reload it.");
					configFileInputStream = new FileInputStream(configFile);
					prop.load(configFileInputStream);
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				} finally {
					if ( configFileInputStream != null ) {
						try {
							configFileInputStream.close();
							configFileInputStream = null;
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				cachedLastModified = lastModified;
				freshCacheRequired = true;
			} else {
				checkLastModifiedDelay += checkLastModifiedDelay;
			}
		}
		return freshCacheRequired;
	}
}