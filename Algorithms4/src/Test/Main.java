package Test;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		String end = "";
		int N=0;
		Scanner scan = new Scanner(System.in);
		if(scan.hasNext())	N = scan.nextInt();
		
		int last = 1;
		int cur=0;
		for(int i=1;i<=N;i++){
			if(scan.hasNext())	cur = scan.nextInt();
			for(;last<=cur;last++){
				stack.push(i);
			}
			int pos = stack.pop();
			if(i==N){
				end += (i-pos+1)+"";
			}else{
				end += (i-pos+1)+" ";
			}
		}
		System.out.println(end);

	}

}
