package com.system.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class TextUtils {
	public static final String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; 
	public static final String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
	private static Logger logger = Logger.getLogger(TextUtils.class);
	
	/**
	 * Convert html to text
	 * @param inputString
	 * @return
	 */
	public static String Html2Text(String inputString) {
		String htmlStr = inputString;
		String textStr ="";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		java.util.regex.Pattern p_space;
		java.util.regex.Matcher m_space;
		
		if(inputString==null) return textStr;
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; 
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>";
			String regEx_space = "[\\s]+";
 
			p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(" ");

			p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(" ");
 
			p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(" ");
			
			p_space = Pattern.compile(regEx_space);
			m_space = p_space.matcher(htmlStr);
			htmlStr = m_space.replaceAll(" ");
			
			htmlStr = htmlStr.replaceAll("[^\\w]{6,}", " ");//trim special long characters.
			htmlStr = htmlStr.replaceAll("&.{2,4};", " ");//trim html encode tags
			textStr = htmlStr;
     
		}catch(Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;
	}   
	
	
	public static String TrimScript(String inputString){
		String htmlStr = inputString;
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;

		p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
		m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(" ");

		p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
		m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(" ");
//		htmlStr = TextUtils.TrimNoneWords(htmlStr);
		return htmlStr;
	}
	
	
	private static String TrimNoneWords(String input){
		String ret = input;
		ret = ret.replaceAll("\\W", "");
		return ret;
	}
	
	/**
	 * currency to us format
	 * @param value
	 * @return
	 */
	public static String formatUSCurrency(Number value){
		if(value != null) {
			NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
			nf.setMaximumFractionDigits(0);
			return nf.format(value); 
		}else {
			return "";
		}
	}
	
	public static String encodeUrl(String input){
		String ret = input;
		try {
			ret = ret.replaceAll("\\s{2,}", " ");
			ret = URLEncoder.encode(ret, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("error url-encode string:"+input);
			ret = "";
		}
		return ret;
	}
	
	/**
	public static String removeLast(String input, String toRemove){
		String result = null;
		if(StringUtils.isNotBlank(input)){
			String pattern = "["+toRemove+"[\\s]*]+$";
			result = input.replaceAll(pattern,"");
		}
		return result;
	}
	
	public static String removeLastNoneWords(String input){
		return TextUtils.removeLast(input, "\\W");
	}
	**/
	
	public static String removeOneHtmlTag(String input, String toRemove){
		String result = null;
		if(StringUtils.isNotBlank(input)){
			result = input.replaceAll("<[/]?[\\s]*"+toRemove+"[^>]*>", "");
		}
		return result;
	}
	
	
	
	public static String removeHtmlTags(String input, String... elementTag){
		for (int i = 0; i < elementTag.length; i++) {
			String pattern = "<[/]?[\\s]?"+elementTag[i]+"(.*?)>"; 
			Pattern p = Pattern.compile(pattern);
			Matcher macther = p.matcher(input);
			input = macther.replaceAll("");
		}
		return input;
	}
	
	public static String removeDefaultElements(String input){
		input = TextUtils.removeHtmlTags(input, "a","table","span","input","button","textarea","select");
		return input;
	}
	
	public static String escapeAllHtml(String input){
		String output = null;
		output = TextUtils.Html2Text(input);
		output = output.replace("&", "&amp;");
		output = output.replace("'", "&acute;");
		output = output.replace("\"", "&quot;");
		output = output.replace("<", "&lt;");
		output = output.replace(">", "&gt;");
		return output;
	}
	
}
