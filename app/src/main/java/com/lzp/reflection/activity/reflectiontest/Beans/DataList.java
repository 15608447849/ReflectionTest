package com.lzp.reflection.activity.reflectiontest.Beans;

import java.util.HashMap;


/**
 * 数据封装
 * 
 * 把数据封装到map集合，提供了获取数据的的方法。
 * @author Administrator
 *
 */
public class DataList{
	private String key;

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}

	protected HashMap<String, String> map = new HashMap<String, String>();

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public String GetStringDefualt(String key, String defualtValue) {
		try {
			String object = map.get(key);
			if (object == null) {
				return defualtValue;
			} else {
				return object;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return defualtValue;
		}
	}

	public int GetIntDefualt(String key, int defualtValue) {
		try {
			Object object = map.get(key);
			if (object == null) {
				return defualtValue;
			} else {
				return Integer.parseInt(object.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return defualtValue;
		}
	}

	public double GetdoubleDefualt(String key, double defualtValue) {
		try {
			Object object = map.get(key);
			if (object == null) {
				return defualtValue;
			} else {
				return Double.parseDouble(object.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return defualtValue;
		}
	}

	public void put(String key, String value) {
		map.put(key, value);
	}

	public String ToString() {
		return map.toString();
	}

	public void clear(){
		map.clear();
	}
}
