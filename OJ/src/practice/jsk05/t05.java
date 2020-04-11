package practice.jsk05;

import java.util.Scanner;

public class t05 {

	private static int[] ns;
	private static int ans = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ns = new int[N];
		for(int i = 0; i < N; i++){
			ns[i] = sc.nextInt();
			
		}
		

		//f(0,N-1,new node(0,0));
		System.out.println(ans);
		
		
	}
	


	private static void f(int head, int tail, node nd) {
		if(nd.suan - nd.hua < -1000){
			return;
		}
		
		if(head > tail){
			
			ans = Math.max(ans, (nd.suan - nd.hua));
			System.out.println(ans);
			return;
		}
		
		//蒜头君选前面一个,就要判断第二个和最后一个谁大，花就选谁
		if(ns[head + 1] >= ns[tail]){
			f(head + 2, tail, new node(nd.suan + ns[head], nd.hua + ns[head + 1]));
		}else{
			f(head + 1, tail - 1, new node(nd.suan + ns[head], nd.hua + ns[tail]));
		}
		
		//蒜头君选后面一个,。就要判断第一个和最后第二个个谁大，花就选谁
		if(ns[head] >= ns[tail - 1]){
			f(head + 1, tail - 1, new node(nd.suan + ns[tail], nd.hua + ns[head]));
		}else{
			f(head,tail - 2, new node(nd.suan + ns[tail], nd.hua + ns[tail - 1]));
		}
		
		
		
	}

	public static class node{
		public int suan;
		public int hua;
		public node(int suan, int hua){
			this.suan = suan;
			this.hua = hua;
		}
	}

}
