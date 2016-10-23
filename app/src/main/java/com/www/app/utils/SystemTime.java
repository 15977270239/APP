package com.www.app.utils;

public class SystemTime {
	public static String getTime() {
		return Long.toString(System.currentTimeMillis()).substring(0, 10);
	}
}
