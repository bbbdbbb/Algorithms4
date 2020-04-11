package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**  �����ѧϰ����   �����������bfs
 * 	 ����A�ε�ʱ���
 * 	https://www.jisuanke.com/course/6497/341087
 * 
 *  ͬһ�������ϣ�S��㣬T�յ�  ��ĳһʱ����xλ�������ֲ�����
 *  1.x += 1
 *  2.x -= 1
 *  3.x *= 2
 *  3.(xΪż��) x /= 2 
 *  
 *  ��S��T�����ٲ�����
 *  
	���룺
2
5 17
4 8
	�����
8
2

*  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_bfs01   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��10�� ����3:46:02   
* @version        
*/
public class jsk_bfs01 {

	private static int N;
	private static int[] S;
	private static int[] T;
	private static boolean[] vis;
	private static LinkedList<node> q;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		T = new int[N];
		for(int i = 0; i < N; i++){
			S[i] = sc.nextInt();
			T[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++){
			//��ʼ������ �� vis����     
			//ÿ�ζ� ʵ����һ�� ���ж��󣬵����ڴ泬��
//			Queue<node> q = new LinkedList<node>();
			q = new LinkedList<node>();
			q.add(new node(S[i],0));
			vis = new boolean[1000000];
					
			vis[S[i]] = true;
			
			while(!q.isEmpty()){
				node nd = q.poll();
				if(nd.now == T[i]){
					System.out.println(nd.cnt * 2);
					break;
				}
				
				if(nd.now + 1 < 1000000 && !vis[nd.now + 1]){
					vis[nd.now + 1] = true;
					q.add(new node(nd.now + 1, nd.cnt + 1));
				}
				
				if(nd.now - 1 > 0 && !vis[nd.now - 1]){
					vis[nd.now - 1] = true;
					q.add(new node(nd.now - 1, nd.cnt + 1));
				}
				
				if(nd.now * 2 < 1000000 && !vis[nd.now * 2]){
					vis[nd.now * 2] = true;
					q.add(new node(nd.now * 2, nd.cnt + 1));
				}
				
				if(nd.now % 2 == 0 && nd.now / 2 > 0 && !vis[nd.now / 2]){
					vis[nd.now / 2] = true;
					q.add(new node(nd.now / 2, nd.cnt + 1));
				}
			}
			
			//��ն���
			q.clear();
			
		}
		
	}


	
	
	public static class node{
		public int now;
		public int cnt;
		
		public node(int now,int cnt){
			this.now = now;
			this.cnt = cnt;
		}
	}

}
