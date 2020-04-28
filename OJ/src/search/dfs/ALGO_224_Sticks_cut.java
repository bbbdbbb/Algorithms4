package search.dfs;

import java.util.Arrays;
import java.util.Scanner;


/** 剪枝过的dfs，很多细节，需要仔细理解
 * 算法训练 Sticks
 * http://lx.lanqiao.cn/problem.page?gpid=T572  
*    
	输入：
9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
	输出：
6
5

*    
* 项目名称：OJ   
* 类名称：ALGO_224_Sticks   
* 创建人：bbbdbbb   
* 创建时间：2020年3月5日 下午8:03:26   
* @version        
*/
public class ALGO_224_Sticks_cut {
	
	private static int n;//小木棍的数量
	private static int[] s;//按长度从小到大存储每一个小木棍的长度
	private static int sum;//所有小木棍的的长度之和
	private static int max;//所求的 木棒长度
	private static boolean[] vis;
	private static int parts;//需要拼凑的木棒数量

	
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		//n = scan.nextInt();//小木棍的数量
		while((n=scan.nextInt()) != 0 ){
			s = new int[n];
			vis = new boolean[n];
//我忽略了这里 sum 必须每次while循环都要赋值为0，导致第一次以后的计算出错			
			sum = 0;				
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
			//n = scan.nextInt();
		}
		
		scan.close();
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
		
		//System.out.println("\nf() next="+next);

		if(len==max){//当前正在拼凑的木棒的长度 等于 我们所猜测的木棍的长度
			cpl++;//成功拼凑的木棒数量加一
			len = 0;//重新拼凑另外一根木棒，所以将当前正在拼凑的木棒的长度置为0
			next = n-1;//从头开始选择木棍
		}
		
		if(cpl==parts){//当前拼凑成功的木棒数量等于 所预测的木棒数量
			return true;   //说明  搜索成功，满足条件，放回true
		}
		
		while(next>=0){
			if(vis[next]==false){//当前木棍没被选过
				
				if(len+s[next]<=max){//当前选中的木棍s[next]可以使用
					vis[next] = true;
					if(f(len+s[next],next-1,cpl)){
						return true;
					}
					
					vis[next] = false;
					
					//若在本次搜索失败时，len=0，则以当前最长木棍为第一根木棍，无法组合剩下的木棍，成为一个完整的木棒
					if(len == 0){
						break;
					}
					
					//len加上当前的木棍s[next]等于一根完整的木棒，当后面的木棍不能成功拼凑
					if(len+s[next] == max){
						break;
					}										
				}
				
				//len+s[next] > max  跳过同等长度的木棍
				int i = next-1;
				while(i>=0 && s[next]==s[i]){
					i--;
				}
				next = i;// !!!注意：     上面先i = next-1;  现在 又 next = i;   这里有个隐含的信息就是  next至少减一,已经完成了更新
				
				//判断剩余木棍的长度+当前已拼凑长度len 是否大于or等于  max
				int rest = 0;
				while(i>=0){
					if(vis[i]==false){
						rest += s[i];
					}
					i--;
				}
				
				//剩余木棍的长度+当前已拼凑长度len 小于 max
				if(rest+len<max){
					break;
				}
				
				continue;//上面已经更新了next，这里必须直接跳到while，否则继续执行会使得next多一
			}
			
			next--;
		}
		
		return false;	
		
	}

	
}
