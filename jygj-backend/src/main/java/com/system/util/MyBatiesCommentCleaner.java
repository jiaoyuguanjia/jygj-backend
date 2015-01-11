package com.system.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class MyBatiesCommentCleaner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		try {
			File f = new File(path);
			if(f.exists() && f.isDirectory()){
				File[] files = f.listFiles();
				for (File file : files) {
					StringBuffer sb = new StringBuffer();
					BufferedReader br = new BufferedReader(new FileReader(file));
				    while(br.ready()){
				    	sb.append(br.readLine()+"\r\n");
				    }
				    br.close();
				}
			}else if(f.isFile()){
				System.out.println("请输入文件夹目录");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
