package com.qa.dt.test;

public class Demo {

	public static void main(String[] args) {
		String s="mohanraj";
		int count1=0;
		int count2=0;
		for(int i=0;i<s.length();i++){
		char ch=s.charAt(i);
		if(ch=='a') {
		count1++;
		}else if(ch=='o') {
			count2++;
		}
		System.out.println(count1);
		System.out.println(count2);
		}
	
	}}

