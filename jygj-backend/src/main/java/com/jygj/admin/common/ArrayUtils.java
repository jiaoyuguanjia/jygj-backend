package com.jygj.admin.common;


public class ArrayUtils {

	public static boolean contains(Object[] arrays, Object obj) {
		if (arrays != null && arrays.length > 0) {
			for(Object o : arrays) {
				if (o.equals(obj)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
