package Test;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static int update(int ans,int a,int b){
		if(ans<(a^b))		return a^b;
		else				return ans;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0;

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a[] = new int[N];
		
		for(int i=0;i<N;i++){
			int t = scan.nextInt();
			while(!stack.isEmpty() && stack.peek()<t){
				ans = update(ans,stack.peek(),t);
				stack.pop();
			}
			if(!stack.isEmpty())
				ans = update(ans,stack.peek(),t);
			stack.push(t);
		}
		
		System.out.println(ans);
	}

}
