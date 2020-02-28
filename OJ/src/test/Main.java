package test;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		String str = f(n);
		
		System.out.print(str);

	}

	private static String f(int n) {
		
		String temp = "";
		
//		if(n==0) return "(0)";
//		if(n==1) return "";
//		if(n==2) return "(2)";
		
		//将整数转化为二进制
		String binaryN = Integer.toBinaryString(n);
		int N = binaryN.length();
		System.out.println("bN:"+binaryN);
		for(int i=0;i<N;i++){
			if(binaryN.charAt(i)=='1' && i==N-1){
				temp = temp + "2(0)";
			}else if(binaryN.charAt(i)=='1' && i==N-2){
				temp = temp + "2";
			}else if(binaryN.charAt(i)=='1' && i==N-3){
				temp = temp + "2(2)";
			}else if(binaryN.charAt(i)=='1'){
				temp = temp + "2(" + f(binaryN.length()-i-1) + ")";
			}
			
			
			if(i!=N-1 && binaryN.charAt(i)=='1' && binaryN.lastIndexOf('1')>i)	temp = temp + "+";
		}
		return temp;
	}


}
