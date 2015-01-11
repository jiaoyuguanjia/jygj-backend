package com.system.util;

/**
 * 进制转换工具，最大支持digits长度的进制
 * @author Michael
 * May 29, 2014
 */
public class ScaleConverter {
	public final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
			'N', 'P', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z' };//不包含字母I 和字母O

	/**
	 * 将十进制的数字转换为指定进制的字符串。
	 * @param i
	 *            十进制的数字。
	 * @param system
	 *            指定的进制，常见的2/8/16。
	 * @return 转换后的字符串。
	 */
	public static String numericToString(long i, int system) {
		long num = 0;
		system = updateSystemParam(system);
		if (i < 0) {
			num = ((long) 2 * 0x7fffffff) + i + 2;
		} else {
			num = i;
		}
		char[] buf = new char[32];
		int charPos = 32;
		while ((num / system) > 0) {
			buf[--charPos] = digits[(int) (num % system)];
			num /= system;
		}
		buf[--charPos] = digits[(int) (num % system)];
		return new String(buf, charPos, (32 - charPos));
	}

	/**
	 * 将其它进制的数字（字符串形式）转换为十进制的数字。
	 * 
	 * @param s
	 *            其它进制的数字（字符串形式）
	 * @param system
	 *            指定的进制，常见的2/8/16。
	 * @return 转换后的数字。
	 */
	public static long stringToNumeric(String s, int system) {
		s = s.toUpperCase();
		system = updateSystemParam(system);
		char[] buf = new char[s.length()];
		s.getChars(0, s.length(), buf, 0);
		long num = 0;
		for (int i = 0; i < buf.length; i++) {
			for (int j = 0; j < digits.length; j++) {
				if (digits[j] == buf[i]) {
					num += j * Math.pow(system, buf.length - i - 1);
					break;
				}
			}
		}
		return num;
	}
	
	private static int updateSystemParam(int system){
		if(system < 2){
			system = 2;
		}else if(system > digits.length){
			system = digits.length;
		}
		return system;
	}
	
	
}