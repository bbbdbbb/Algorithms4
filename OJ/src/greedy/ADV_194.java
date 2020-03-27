package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** 贪心算法，类似于OS中的进程资源分配有关的“最少需求先分配”
 * 算法提高 盾神与积木游戏
 * ADV-194
 * http://lx.lanqiao.cn/problem.page?gpid=T361
 *   
*    
* 项目名称：OJ   
* 类名称：ADV_194   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月27日 下午8:44:22   
* @version        
*/
public class ADV_194 {

	public static node[] nds;
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		for(int mCount = 0; mCount < m; mCount++){
			int sum = 0;//记录完成作品的小朋友捐出来的积木
			
			int n = scan.nextInt();
			nds = new node[n];
			for(int nC = 0; nC < n; nC++){
				nds[nC] = new node(scan.nextInt(),scan.nextInt());
			}			
			//nds = sort(nds);
			Arrays.sort(nds, new nodeComparator());

			
			int i = 0;
			for(; i < n; i++){
				if(nds[i].hava + sum >= nds[i].need){
					//完成作品的小朋友捐出自己的积木
					sum += nds[i].hava;
				}else{
					//小朋友nds[i]无法完成作品
					break;
				}
			}
			
			if(i == n){
				//所以小朋友都完成了作品
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			//测试输入   -->  测出 第一个大for循环错误： 将mCount++ 误写为 m++
//			System.out.println(nds.length);
//			for (int i = 0; i < nds.length; i++) {
//				System.out.println(nds[i].hava + "  " + nds[i].need);
//			}
		}
		
		
		//计时，在提交答案的时候要删除
		//long endMili=System.currentTimeMillis();
		//System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}
	
	public static class node{
		public int hava;
		public int need;
		
		public node(int have,int need){
			this.hava = have;
			this.need = need;
		}
	}
	
	//创建node的比较器
	public static class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.need - o1.hava - o2.need + o2.hava;
		}
		
	}
	
	public static node[] sort(node[] nds){
		
		int len = nds.length;
		for(int i = 0; i < len; i++){
			for(int j = 1; j < len -i; j++){
				if(nds[j-1].need - nds[j-1].hava - nds[j].need + nds[j].hava > 0){
					node temp = nds[j-1];
					nds[j-1]  = nds[j];
					nds[j]    = temp;
				}
			}
		}
		
		return nds;
	}
	
	
}
