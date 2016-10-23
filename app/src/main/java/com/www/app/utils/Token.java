package com.www.app.utils;

import android.content.Context;

public class Token {
	public static String getToken(Context context) {
//		return  "t";
		return SPUtils.getPrefString(context, Pkey.token, "");
	}
}
