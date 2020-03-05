package DFS;

import java.util.Arrays;
import java.util.Scanner;

/** 本代码  暴力搜索  ， 严重超时，需要剪枝
 * 算法训练 Sticks
 * http://lx.lanqiao.cn/problem.page?gpid=T572  
*    
* 项目名称：OJ   
* 类名称：ALGO_224_Sticks   
* 创建人：bbbdbbb   
* 创建时间：2020年3月5日 下午8:03:26   
* @version        
*/
public class ALGO_224_Sticks {
	
	private static int n;//小木棍的数量
	private static int[] s;//按长度从小到大存储每一个小木棍的长度
	private static int sum;//所有小木棍的的长度之和
	private static int max;//所求的 木棒长度
	private static boolean[] vis;
	private static int parts;//需要拼凑的木棒数量

	
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();//小木棍的数量
		while(n!=0){
			s = new int[n];
			vis = new boolean[n];
			sum = 0;				//我忽略了这里，导致第一次以后的计算出错
			for(int i=0;i<n;i++){
				s[i] = scan.nextInt();//先存储，一会再排序
				sum += s[i];
			}
			Arrays.sort(s);//排序，长度由小到大
			max = s[n-1];//先猜测木棒的长度等于最长木棍的长度，再逐步加一，判断是否满足条件


			for(;max<=sum;max++){
				if(sum%max==0){
					parts = sum/max;
					
					if(f(0,n-1,0)){
						System.out.println(max);
						break;
					}
				}
			}

			//System.out.println("\nn="+n);
			n = scan.nextInt();
		}
		
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	
	/**
	 * @param len	记录当前正在凑的木棒的长度
	 * @param next	下一个木棍需要判断的索引
	 * @param cpl	成功拼凑的木棒数量
	 * @return
	 */
	private static boolean f(int len,int next, int cpl) {
		
		System.out.println("\nf() next="+next);

		if(len==max){//当前正在拼凑的木棒的长度 等于 我们所猜测的木棍的长度
			cpl++;//成功拼凑的木棒数量加一
			len = 0;//重新拼凑另外一根木棒，所以将当前正在拼凑的木棒的长度置为0
			next = n-1;//从头开始选择木棍
		}
		
		if(cpl==parts){//当前拼凑成功的木棒数量等于 所预测的木棒数量
			return true;   //说明  搜索成功，满足条件，放回true
		}
		
		while(next>=0){
			if(!vis[next]){
				if(len+s[next]<=max){//当前选中的木棍s[next]可以使用
					vis[next] = true;
					if(f(len+s[next],next-1,cpl)){
						return true;
					}
					
					vis[next] = false;
				}
			}
			
			next--;
		}
		
		return false;	
		
	}

}
