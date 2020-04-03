package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static Set<String> hs = new HashSet<String>();



	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

//		for(int i = 0; i < 1048576; i++){
//			hs.add(String.valueOf(i));
//		}
		
		String str = "123456789";
		hs.add(str);
		char[]  ch = str.toCharArray();
		ch[0] = '1';
		
		System.out.println(hs.contains(String.valueOf(ch)));
		
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	
	

	
}