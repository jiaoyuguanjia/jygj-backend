package com.system.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CommentFilter {

	public static final String[] javaComment = new String[] { "/*", "*/" };
	public static final String[] xmlComment = new String[] { "<!--", "-->" };
	private static boolean patternStartted = false;

	private static String filterComment(String input, String[] commentPattern) {
		if (input != null && input.trim().length() == 0) {
			return input;
		}
		if (input != null && commentPattern != null
				&& commentPattern.length > 0) {
			if (input.contains(commentPattern[0])) {
				// 包含注释的开始
				if (!input.contains(commentPattern[1])) {
					patternStartted = true;// 不是单行注释
				}
				return null;
			} else if (input.contains(commentPattern[1])) {
				patternStartted = false;
				return null;
			} else if (patternStartted) {
				return null;
			} else {
				return input;
			}
		}
		return null;
	}

	public static void doFilter(String folderPath) throws Exception {
		File f = new File(folderPath);
		if (f.exists() && f.isDirectory()) {
			File[] fiels = f.listFiles();
			for (File file : fiels) {
				if (file.isFile()) {
					System.out.println("过滤文件 "+file.getAbsolutePath());
					String commentStyle[] = null;
					if(file.getAbsolutePath().endsWith(".java")){
						commentStyle = javaComment;
					}else if(file.getAbsolutePath().endsWith(".xml")){
						commentStyle = xmlComment;
					}
					if(commentStyle != null){
						StringBuffer sb = new StringBuffer();
						BufferedReader br = new BufferedReader(new FileReader(file));
						while (br.ready()) {
							String line = filterComment(br.readLine(), commentStyle);
							if (line != null) {
								sb.append(line).append("\r\n");
							}
						}
						br.close();
						FileWriter fw = new FileWriter(file);
						fw.write(sb.toString());
						fw.flush();
						fw.close();
					}
				} else {
					doFilter(file.getAbsolutePath());
				}
			}
		} else {
			System.out.println("请输入正确目录地址");
		}
	}

	public static void main(String[] args) {
		try {
			CommentFilter
					.doFilter("D:/syxdoc/git/jygj-backend/jygj-backend/src/main/java/com/wuya/dao");
			CommentFilter
			.doFilter("D:/syxdoc/git/jygj-backend/jygj-backend/src/main/java/com/wuya/model");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
