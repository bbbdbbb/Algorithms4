package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**  计蒜客学习中心   广度优先搜索bfs
 * 	 哆啦A梦的时光机
 * 	https://www.jisuanke.com/course/6497/341087
 * 
 *  同一坐标轴上，S起点，T终点  。某一时刻在x位置有四种操作”
 *  1.x += 1
 *  2.x -= 1
 *  3.x *= 2
 *  3.(x为偶数) x /= 2 
 *  
 *  求S到T的最少步数？
 *  
	输入：
2
5 17
4 8
	输出：
8
2

*  
*    
* 项目名称：OJ   
* 类名称：jsk_bfs01   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月10日 下午3:46:02   
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
			//初始化队列 和 vis数字     
			//每次都 实例化一个 队列对象，导致内存超了
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
			
			//清空队列
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
