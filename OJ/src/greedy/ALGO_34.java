package greedy;

import java.util.Arrays;
import java.util.Scanner;

/** 贪心算法，细节。虽然自己凑出了所以情况，但是感觉代码不够优雅，过段时间优化一下   ->  4月24日，代码已优化，简洁
 * 算法训练 纪念品分组
 * http://lx.lanqiao.cn/problem.page?gpid=T96
 * 
 * 问题描述
*　元旦快到了，校学生会让乐乐负责新年晚会的纪念品发放工作。为使得参加晚会的同学所获得的纪念品价值 相对均衡，他要把购来的纪念品根据价格进行分组，但每组最多只能包括两件纪念品，并且每组纪念品的价格之和不能超过一个给定的整数。为了保证在尽量短的时 间内发完所有纪念品，乐乐希望分组的数目最少。
*　你的任务是写一个程序，找出所有分组方案中分组数最少的一种，输出最少的分组数目。  
*    
* 项目名称：OJ   
* 类名称：ALGO_34   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月25日 下午10:41:43   
* @version        
*/

public class ALGO_34{
	
	public static int[] ns;
	public static boolean[] bis;
	
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		ns = new int[n];
		bis = new boolean[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		Arrays.sort(ns);
		
		int count = 0;
		for(int i = n - 1; i >= 0; i--){
			if(bis[i])		continue;
			
			//boolean flag = false;
			int j = 0;
			for(; j < i; j++){
				if(!bis[j] && ns[j] + ns[i] <= w ){
					bis[j] = true;
					bis[i] = true;
					count++;
					//flag = true;
					break;
				}
			}
			if(j == i){
				bis[i] = true;
				count++;
			}
		}
		
		System.out.println(count);
	}
}