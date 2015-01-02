package com.wuya.servcie.ws.util;


import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonUtils {
	public static final String[] JSON_EXCLUDE_FIELDS = new String[]{"password", "version", "lastModifiedDtm", "lastModifiedBy", "createdDtm", "createdBy", "deleted"};
	public static final String DEFAULT_JSON_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	private JsonUtils() {
		super();
	}

	
	public static String toJSON(final Object target) throws Exception {
		return toJSON(target, null, null);
	}

	
	public static String toJSON(final Object target, final String datePattern) throws Exception {
		return toJSON(target, null, datePattern);
	}

	
	public static String toJSON(final Object target, final String[] excludes) throws Exception {
		return toJSON(target, excludes, null);
	}

	/**
	 * Convert object to JSON String
	 * @param target
	 * @param excludes
	 * @param datePattern
	 * @param customerConvertClass: these class will add specified config while convert
	 * @return
	 * @throws Exception
	 */
	public static String toJSON(final Object target, final String[] excludes,
			 final String datePattern, Class<?>... customerConvertClass)throws Exception {
		JsonConfig config = new JsonConfig();
		if (null != excludes && 0 != excludes.length) {
			config.setExcludes(excludes);
		}
		
		final String newPattern;

		if (null == datePattern || datePattern.trim().equals("")) {
			newPattern = DEFAULT_JSON_DATE_PATTERN;
		}else{
			newPattern = datePattern;
		}
			config.registerJsonValueProcessor(java.util.Date.class,
					new JsonValueProcessor() {
						public Object processArrayValue(Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						public Object processObjectValue(String s, Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						private String process(Object obj) {
							if (null == obj) {
								return "";
							}
							java.util.Date date = (java.util.Date) obj;
							java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
									newPattern.trim());
							return format.format(date);
						}
					});
			config.registerJsonValueProcessor(java.math.BigDecimal.class,
					new JsonValueProcessor() {
						public Object processArrayValue(Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						public Object processObjectValue(String s, Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						private String process(Object obj) {
							if (null == obj) {
								return "";
							}
							java.math.BigDecimal bd =(java.math.BigDecimal) obj;
							return bd.toString();
						}
					});
			config.registerJsonValueProcessor(java.sql.Date.class,
					new JsonValueProcessor() {
						public Object processArrayValue(Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						public Object processObjectValue(String s, Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						private String process(Object obj) {
							if (null == obj) {
								return "";
							}
							java.sql.Date date = (java.sql.Date) obj;
							java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
									newPattern.trim());
							return format.format(date);
						}
					});
			config.registerJsonValueProcessor(java.sql.Timestamp.class,
					new JsonValueProcessor() {
						public Object processArrayValue(Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						public Object processObjectValue(String s, Object obj,
								JsonConfig jsonconfig) {
							return this.process(obj);
						}

						private String process(Object obj) {
							if (null == obj) {
								return "";
							}
							java.sql.Timestamp date = (java.sql.Timestamp) obj;
							java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
									newPattern.trim());
							return format.format(date);
						}
					});
			
//			if(customerConvertClass != null){
//				for (int i = 0; i < customerConvertClass.length; i++) {
//					addConfig(config, customerConvertClass[i]);
//				}
//			}
			
		String json = null;
		if (target instanceof Collection || target instanceof Object[]) {
			JSONArray jsonArray = JSONArray.fromObject(target, config);
			json = jsonArray.toString();
		} else {
			JSONObject jsonObject = JSONObject.fromObject(target, config);
			json = jsonObject.toString();
		}
		return json;
	}
	
	
	private static void addConfig(JsonConfig config, Class inputClass){
//		if(inputClass == TextDetail.class ){
//			config.registerJsonValueProcessor(TextDetail.class, new JsonValueProcessor(){
//				
//				@Override
//				public Object processArrayValue(Object obj, JsonConfig config) {
//					return this.process(obj);
//				}
//	
//				@Override
//				public Object processObjectValue(String str, Object obj,
//						JsonConfig config) {
//					return this.process(obj);
//				}
//				
//				private String process(Object obj) {
//					if (null == obj) {
//						return "";
//					}
//					String ret = "";
//					if(obj instanceof TextDetail){
//						TextDetail text = (TextDetail)obj;
//						ret = text.getValue();
//					}
//					return ret;
//				}
//				
//			});
//		}
	}

}
