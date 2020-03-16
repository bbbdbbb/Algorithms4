package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int[] pazz;
	public static char[] chs = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};


	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		
	    int N = scan.nextInt();
	    int R = scan.nextInt();
	        
	    String ans = "";
	    if(N < 0)		N += Math.pow(2,32);
	        
	    ans = shift(N,R);
	        
	    System.out.println(ans); 
	        
	    
		scan.close();
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}
	
	
	  public static String shift(int N, int R){
	        
	        char[] nums = new char[32];
	        int head = nums.length;
	        
	        if(N == 0)		return "0";
	        while(N!=0){
                int mod = N % R;
                
                nums[--head] = chs[mod];
                System.out.println(nums[head]);
                N /= R;
	        }
	        
	               
	        return String.valueOf(nums,head,32-head).toUpperCase();
	    }
	
	

}