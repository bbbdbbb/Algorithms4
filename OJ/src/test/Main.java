package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.nextLine();
		char[] chs = new char[N];
		for(int i = 0; i < N; i++){
			
			chs[i] = scan.next().charAt(0);
			System.out.println(chs[i]+""+i);
			scan.nextLine();
		}
		
		int pri = 0;
		int end = N-1;
		//贪心选择，从头和尾中选择一个字典序列小的首字母
		while(pri <= end){
			boolean left = false;//判断 获取 头部或尾部的首字母
			
			for(int i = 0; pri + i <= end; i++){
				if(chs[pri] < chs[end]){
					left = true;//获取 头部的首字母
					break;
				}else if(chs[pri] > chs[end]){
					left = false;
					break;
				}

			}
			
			
			if(left)	System.out.print(chs[pri++]);
			else		System.out.print(chs[end--]);
		}
		
		
		scan.close();
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

}