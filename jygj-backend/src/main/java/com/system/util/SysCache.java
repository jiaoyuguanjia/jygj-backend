package com.system.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SysCache {
	private Logger logger = Logger.getLogger(SysCache.class);
	@SuppressWarnings("unchecked")
	private Map<String, Object> cacheItemMap = new LRUMap(2000);
	private Map<String, Object> sysconfig;
	private ApplicationContext context;
	
	private SysCache() {
		logger.debug("====== new cache instance created ======");
		context = new FileSystemXmlApplicationContext(new String[] { "classpath:applicationContext.xml", "classpath:systemApplicationContext.xml", "classpath:omsApplicationContext.xml" });
	}

	private static SysCache instance = null;

	public static synchronized SysCache getInstance() {
		if (instance == null) {
			instance = new SysCache();
		}
		return instance;
	}
	
	private Object getBean(String beanId) {
		return context.getBean(beanId);
	}
	
	
		
	private static String getCachedKey(Class<?> classes, String key){
		return classes.getName()+"_"+key;
	}
	
	public Object getCachedItem(String key){
		return cacheItemMap.get(key);
	}
	
	public void updateCachedItem(String key, Object value){
		cacheItemMap.put(key, value);
	}
	
	public void clear(String key) {
		cacheItemMap.remove(key);
	}
	
	public void clear() {
		cacheItemMap.clear();
	}
	
	public void cleanSysConfig(){
		SysConfig.initSysconfig();
		sysconfig.clear();
	}
	
	public String getSysConfig(String key){
		String result = null;
		if(key == null){
			return null;
		}
		if(sysconfig == null){
			sysconfig = new HashMap<String, Object>();
		}
		if(sysconfig.containsKey(key.toLowerCase())){
			result = sysconfig.get(key.toLowerCase()).toString();
		}else	if(SysConfig.getItem(key) != null){
			result = SysConfig.getItem(key);
			sysconfig.put(key.toLowerCase(), result);
		}else{
			//error find SysConfig
			logger.error("can't find system config："+key.toLowerCase());
		}
		return result;
	}
	
	public Object getSysConfig(String key, Class<?> valueType){
		Object obj = null;
		if(key != null){
			String ret = this.getSysConfig(key);
			if(StringUtils.isNotBlank(ret)){
				obj = ret;
				if(valueType.getName().equals(Integer.class.getName())){
					obj = Integer.parseInt(ret);
				}else if(valueType.getName().equals(Long.class.getName())){
					obj = Long.parseLong(ret);
				}else if(valueType.getName().equals(Boolean.class.getName())){
					obj = Boolean.parseBoolean(ret);
				}else if(valueType.getName().equals(Float.class.getName())){
					obj = Float.parseFloat(ret);
				}else{
					logger.warn("System does't support such converting "+obj+" ==> "+valueType.getName());
				}
			}			
		}	
		return obj;
	}
	
	
}