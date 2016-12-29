package com.rxwx.common.utils;


import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	/** 
	 * @Description:把数组转换为一个用逗号分隔的字符串 ，以便于用in+String 查询 
	 */  
	public static String converToString(String[] ig) {  
	    String str = "";  
	    if (ig != null && ig.length > 0) {  
	        for (int i = 0; i < ig.length; i++) {  
	            str += ig[i] + ",";  
	        }  
	        str = str.substring(0, str.length() - 1); 
	    }
	    return str;  
	}  
	  
	/** 
	 * @Description:把list转换为一个用逗号分隔的字符串 
	 */  
	public static String listToString(List list) {  
	    StringBuilder sb = new StringBuilder();  
	    if (list != null && list.size() > 0) {  
	        for (int i = 0; i < list.size(); i++) {  
	            if (i < list.size() - 1) {  
	                sb.append(list.get(i) + ",");  
	            } else {  
	                sb.append(list.get(i));  
	            }  
	        }  
	    }  
	    return sb.toString();  
	} 
	
	/**
	 * 有为空的
	 * @param strings
	 * @return
	 */
	public static boolean hasNull(String...strings){
		boolean bool = false;
		for(String s:strings){
			if(StringUtils.isBlank(s)){
				bool = true;
			}
		}
		return bool;
	}
	
	/**
	 * 全部不为空
	 * @param strings
	 * @return
	 */
	public static boolean allNotNull(String...strings){
		boolean bool = true;
		for(String s:strings){
			if(StringUtils.isBlank(s)){
				bool = false;
				break;
			}
		}
		return bool;
	}
	
	public static boolean hasNotNull(String...strings) {
		boolean bool = false;
		for(String s:strings){
			if(StringUtils.isNoneBlank(s)){
				bool = true;
				break;
			}
		}
		return bool;
	}
	
	/**
	 * 判断list不为空
	 * @param list
	 * @return
	 */
	public static boolean listNotNull(List list){
		return list!=null;
	}
	
	/**
	 * 判断list不为空，并且有数据
	 * @param list
	 * @return
	 */
	public static boolean listNotEmpty(List list){
		return list!=null&&list.size()>0;
	}
	
	
	/**
	 * 判断list为null
	 * @param list
	 * @return
	 */
	public static boolean listIsNull(List list){
		return list==null;
	}
	
	/**
	 * 判断list不为空，但是无内容
	 * @param list
	 * @return
	 */
	public static boolean listIsEmpty(List list){
		return list!=null&&list.size()==0;
	}
	
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "123";
		String s3 = "456";
		boolean bool = allNotNull(s3,s2);
		//System.out.println(bool);
		//System.out.println(hasNull(s1,s2));
//		System.out.println(hasNull(s3,s2));
		
		List<String> list = null;
		
		System.out.println(listIsEmpty(list));
	}

	
	
	
}
