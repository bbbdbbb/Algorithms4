package greedy;

import java.util.Scanner;

/** 
 * 贪心算法   经典 ，每次都选最大值。   使用的是遍历数组来找最大值，等学习了相应的集合后，再优化代码  
 * 算法训练 石子游戏
 * http://lx.lanqiao.cn/problem.page?gpid=T573
*  
* 问题描述：
*   石子游戏的规则如下：
*　　地上有n堆石子，每次操作可选取两堆石子（石子个数分别为x和y）并将它们合并，操作的得分记为(x+1)×(y+1)，对地上的石子堆进行操作直到只剩下一堆石子时停止游戏。
*　　请问在整个游戏过程中操作的总得分的最大值是多少？   
*    
*    
* 项目名称：OJ   
* 类名称：ALGO_225   

* 创建人：bbbdbbb   
* 创建时间：2020年3月25日 下午4:33:53   
* @version        
*/
public class ALGO_225 {
	
	public static long[] nums;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		nums = new long[n]; 
		
		for(int i = 0; i < n; i++){
			nums[i] = scan.nextLong();
		}
		
		long ans = 0;
		int max1 = 1;//次大值  index
		int max2 = 0;//最大值
		while(n > 1){
			if(nums[max1] > nums[max2]){
				swap(max1,max2);
				int temp = max1;
				max1 = max2;
				max2 = temp;
			}
			
			/*
			 * 找当前石堆中数目最多的最大值和次大值
			 */
			for(int i = 1; i < n; i++){
				//大于次大值，记录索引
				if(nums[i] > nums[max1]){
					max1 = i;
				}
				//如果nums[i]大于次大值，并且已经在上面记录了索引
				//但是 它 也有可能 并当前记录的最大值还大，所以在这里进行一次判断
				if(nums[max1] > nums[max2]){
					int temp = max1;
					max1 = max2;
					max2 = temp;
				}				
			}
			
//			
//			System.out.println("打桩"+n);
//			for(int i = 0; i < n; i++){
//				System.out.print(nums[i] + "  ");
//			}
//			System.out.println(nums[max1] + " and "+ nums[max2]);
			
			ans += (nums[max1] + 1) * (nums[max2] + 1);
			nums[max2] += nums[max1];
			if(max2 == n-1){
				swap(max1,max2);
				int temp = max1;
				max1 = max2;
				max2 = temp;
				swap(0,max2);
			}else{
				swap(0,max2);
				swap(max1,n-1);
			}
			
			max2 = 0;
			max1 = 1;
			n--;
		}
		
		System.out.println(ans);
		
	}
	
	
	public static void swap(int a,int b){
		long temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
