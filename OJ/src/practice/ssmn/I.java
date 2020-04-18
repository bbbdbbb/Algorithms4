package practice.ssmn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**   一带一路上的国家通电
*    
* 项目名称：OJ   
* 类名称：I   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月18日 上午10:48:42   
* @version        
*/
public class I {

	private static int[][] ns;
	private static boolean[] vis;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n][3];
		for(int i = 0; i < n; i++){
			ns[i][0] = sc.nextInt();
			ns[i][1] = sc.nextInt();
			ns[i][2] = sc.nextInt();
		}
		
		vis = new boolean[n];
		int len = n * (n - 1) / 2;
		node[] nds = new node[len];
		int cnt = 0;
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				double aa = Math.sqrt((ns[i][0] - ns[j][0])*(ns[i][0] - ns[j][0]) + (ns[i][1] - ns[j][1])*(ns[i][1] - ns[j][1])) + (ns[i][2] - ns[j][2])*(ns[i][2] - ns[j][2]);             
				nds[cnt++] = new node(i,j,aa);
			}
		}
		
		Arrays.sort(nds, new nodeComparator());
		double ans = 0.0;
		cnt = 0;
		boolean flag = false;
		for(int i = 0; i < len; i++){
			if(!vis[nds[i].a] || !vis[nds[i].b] || (cnt<n-1) && flag){
				ans += nds[i].d;
				vis[nds[i].a] = true;
				vis[nds[i].b] = true;
				cnt++;
				int b = 0;
				for(; b < n; b++){
					if(!vis[b]){
						break;
					}
				}
				if(b == n)		flag = true;
				//System.out.println(nds[i].a + " -> " + nds[i].b);
			}
		}
		
		System.out.printf("%.2f",ans);
		
	}
	
	public static class node{
		public int a;
		public int b;
		public double d;
		
		public node(int a,int b, double d){
			this.a = a;
			this.b = b;
			this.d = d;
		}
	}
	
	//创建node的比较器
	public static class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return (int) (o1.d - o2.d);
		}
		
	}

}
