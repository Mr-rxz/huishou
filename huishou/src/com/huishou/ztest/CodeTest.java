package com.huishou.ztest;

import com.huishou.util.CodeUtil;

public class CodeTest {
	public static void main(String[] args) {
		String source = "ss\uD83C\uDFA6������ ";
		//String source = "�й�z";
		System.out.println("old:" + source);
		source = CodeUtil.filterEmoji(source);
		System.out.println("new:" + source);
	}
}
