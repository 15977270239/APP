package com.www.app.network;

import android.app.Activity;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;
import com.www.app.utils.Pkey;
import com.www.app.utils.SPUtils;
import com.www.app.utils.T;


/**
 * 网络响应
 *
 * @author ping 2014-4-16 上午10:36:09
 */
public class NetResult {

	/**
	 * 有提示，网络连接且请求没有错误?
	 *
	 * @param activity
	 * @param success
	 * @param object
	 * @param error
	 * @return
	 * @author ping
	 * @create 2014-4-19 下午7:05:24
	 */
	public static boolean isSuccess(Activity activity, boolean success, String object, VolleyError error) {
		if (success && object != null) {
			JSONObject json = null;
			try {
				json = JSONObject.parseObject(object);
			} catch (Exception e) {
			}
			if (json == null) {
				T.showMessage(activity, "获取数据失败，请重试");
			} else if (json.containsKey("success")) {
				if (json.getInteger("success") == 1) {
					return true;
				} else if (json.getInteger("success") == 0) {
					T.showMessage(activity, json.getString("msg"));
					if (json.getString("msg").equals("您的账号在其他终端登陆，请重新登陆！")) {
					  SPUtils.setPrefString(activity, Pkey.token, "");
					}
				} else if (json.containsKey("message")) {
					T.showMessage(activity, json.getString("message"));
				} else {
					T.showMessage(activity, "获取数据失败，请重试");
				}
			} else {
				if (json.containsKey("message")) {
					T.showMessage(activity, json.getString("message"));
				
				} else {
					T.showMessage(activity, "获取数据失败，请重试");
				}
			}

			return false;
		} else {
			VolleyErrorMsg.printError(true, activity, error);
		}
		return false;
	}

	/**
	 * 无提示，网络连接且请求没有错误?
	 *
	 * @param activity
	 * @param success
	 * @param object
	 * @param error
	 * @return
	 * @author ping
	 * @create 2014-4-19 下午7:05:24
	 */
	public static boolean isSuccess2(Activity activity, boolean success, String object, VolleyError error) {
		if (success && object != null) {
			JSONObject json = null;
			try {
				json = JSONObject.parseObject(object);
			} catch (Exception e) {
			}

			if (json == null) {
				T.showMessage(activity, "网络请求失败");
			} else if (json.containsKey("success")) {
				if (json.getInteger("success") == 0) {
					return true;
				}
			}
		} else {
			VolleyErrorMsg.printError(false, activity, error);
		}
		return false;
	}

	public static String getMsg(String object) {
		String result = null;
		if (object == null) {
			result = "网络请求失败";
		} else {
			JSONObject json = null;
			try {
				json = JSONObject.parseObject(object);
			} catch (Exception e) {
			}
			if (json == null) {
				// 网络错误，取到非json数据
			} else if (json.containsKey("message")) {
				try {
					result = json.getString("message");
				} catch (Exception e) {
				}
			}
		}
		return result == null ? "unknow message" : result;
	}
}
