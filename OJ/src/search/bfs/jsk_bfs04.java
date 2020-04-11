package search.bfs;

import java.util.LinkedList;
import java.util.Scanner;


public class jsk_bfs04 {

	private static int sta;
	private static String staStr;
	private static int end;
	private static String endStr;
	private static boolean[] vis = new boolean[10000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sta = sc.nextInt();
		staStr = String.valueOf(sta);
		end = sc.nextInt();
		endStr = String.valueOf(end);
		
		LinkedList<node> q = new LinkedList<>();
		q.add(new node(sta,0));
		vis[sta] = true;
		while(!q.isEmpty()){
			node now = q.poll();
			String nowStr = String.valueOf(now.n);
			//结束bfs
			if(now.n == end){
				System.out.println(now.d);
				break;
			}
			
			//bfs
			//个位
			q = circle(3,1,nowStr,now,q);	
			//十位
			q = circle(2,10,nowStr,now,q);
			//百位
			q = circle(1,100,nowStr,now,q);
			//千位
			q = circle(0,1000,nowStr,now,q);
			
			q = exc(0,1,now,q);
			q = exc(1,2,now,q);
			q = exc(2,3,now,q);
			
		}
		
	}
	
	private static LinkedList<node> exc(int i, int j, node now, LinkedList<node> q) {

		//先交换
		String str = String.valueOf(now.n);
		char[] chs = str.toCharArray();
		char temp = chs[i];
		chs[i] = chs[j];
		chs[j] = temp;
		int num = Integer.parseInt(String.valueOf(chs));
		
		if(!vis[num]){
			vis[num] = true;
			q.add(new node(num,now.d + 1));
		}
		return q;
	}

	private static LinkedList<node> circle(int index, int time, String nowStr, node now, LinkedList<node> q) {
		if(nowStr.charAt(index) != endStr.charAt(index)){
			//加
			if(nowStr.charAt(index) == '9' && !vis[now.n - 8 * time]){
				vis[now.n - 8* time] = true;
				q.add(new node(now.n - 8* time, now.d + 1));
			}else if(nowStr.charAt(index) != '9' && !vis[now.n + 1* time]){
				vis[now.n + 1* time] = true;
				q.add(new node(now.n + 1* time, now.d + 1));
			}
			//减
			if(nowStr.charAt(index) == '1' && !vis[now.n + 8* time]){
				vis[now.n + 8* time] = true;
				q.add(new node(now.n + 8* time, now.d + 1));
			}else if(nowStr.charAt(index) != '1' && !vis[now.n - 1* time]){
				vis[now.n - 1* time] = true;
				q.add(new node(now.n - 1* time, now.d + 1));
			}
		}
		
		return q;

	}

	public static class node{
		public int n;
		public int d;
		public node(int n, int d){
			this.d = d;
			this.n = n;
		}
	}

}
