package com.system.util;

import org.apache.log4j.Logger;

public class Distance {
	private static Logger log = Logger.getLogger(Distance.class);
	private static final double EARTH_RADIUS = 6378137;// 地球半径M

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 返回两个经纬度之间的球面距离(米)
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static int GetDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);

		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		Long distance =  Math.round(s);
		return Integer.parseInt(distance.toString());
	}
	
	public static Integer GetDistance(double lat1, double lng1, String locationString) {
		Double[] gps = new Double[2];
		try{
			if(locationString.contains(",")){
				String[] gpsString = locationString.split(",");
				if(gpsString != null && gpsString.length == 2){
					gps[0] = Double.parseDouble(gpsString[0]);
					gps[1] = Double.parseDouble(gpsString[1]);
				}else{
					return null;
				}
			}
		}catch(Exception e){
			log.error(e.getMessage());
			return null;
		}
		
		return GetDistance(lat1, lng1, gps[0], gps[1]);
	}
	
	public static void main(String[] args) {
		int meters = Distance.GetDistance(31.2221970321, 121.2670898438, 31.6907818061, 118.6083984375);//参考答案：257336
		System.out.println("结果："+meters+ "误差:" + Math.abs(257336 - meters ) *100 /257336f+"%" );
		
	}
	
}