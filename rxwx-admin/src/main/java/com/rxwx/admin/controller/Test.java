package com.rxwx.admin.controller;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		List<String> realList = new ArrayList<String>();
		
		List<String> mrList = new ArrayList<String>();
		mrList.add("1");
		mrList.add("5");
		mrList.add("9");
		mrList.add("12");
		
		
		List<String> rList = new ArrayList<String>();
		rList.add("1");
		rList.add("12");
		
		for (String mr : mrList) {
			for (String res : rList) {
				if(res.equals(mr)){
					realList.add(res);
				}
			}
		}
		System.out.println(realList.size());
	}

}
