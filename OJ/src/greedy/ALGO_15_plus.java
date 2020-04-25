package greedy;

import java.util.Scanner;

/** 贪心算法
 * 算法训练 旅行家的预算 
 * http://lx.lanqiao.cn/problem.page?gpid=T75 
问题描述
　　一个旅行家想驾驶汽车以最少的费用从一个城市到另一个城市（假设出发时油箱是空的）。
给定两个城市之间的距离D1、汽车油箱的容量C（以升为单位）、每升汽油能行驶的距离D2、出发点每升汽油价格P和沿途油站数N（N可以为零），
油站i离出发点的距离Di、每升汽油价格Pi（i=1，2，……N）。计算结果四舍五入至小数点后两位。如果无法到达目的地，则输出“No Solution”。
	样例输入
275.6 11.9 27.4 2.8 2
102.0 2.9
220.0 2.2
	样例输出
26.95 
*    
* 项目名称：OJ   
* 类名称：ALGO_15_plus   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月25日 下午4:45:05   
* @version        
*/
public class ALGO_15_plus {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double D1 = sc.nextDouble();//两个城市之间的距离
		double C = sc.nextDouble();//油箱的容量
		double D2 = sc.nextDouble();//每升油能行驶的距离
		double P = sc.nextDouble();//出发点的油价
		
		int N = sc.nextInt();//加油站的数量
		double[] Pi = new double[N+2];//每个加油站的油价
		double[] Di = new double[N+2];//每个加油站到起点的距离
		double MaxDistance = D2 * C;
		
		//初始化距离和油价数组
		Di[0] = 0; Pi[0] = P;
		Di[N+1] = D1; Pi[N+1] = 0;//将终点也看作为一个加油站，终点的油价是0，所以汽车到达终点时油箱里不会有剩余的油
		for(int i = 1; i <= N; i++){
			Di[i] = sc.nextDouble();
			Pi[i] = sc.nextDouble();
		}
		
		double fee = 0;//费用
		double res = 0;//油箱此时剩余油量
		//判断能否到达终点
		for(int i = 0; i <= N; i++){
			if(Di[i+1] - Di[i] > MaxDistance){//不能到达终点，输出答案，结束程序
				System.out.println("No Solution");
				return;
			}
		}
		//上面的for循环已经判断可以到达终点，进行贪心选择
		//每次选择 比当前加油站油费便宜的最近的加油站
		int i = 0;//i表示当前所在加油站的位置
		while(i <= N){//当i = N + 1时，汽车已经到了终点
			int j = i + 1;
			for(; j <= N + 1; j++){
				if(Di[j] - Di[i] > MaxDistance){
					//在汽车加满油后，也不能到达加油站j
					//并且从加油站i到加油站j-1，加油站i的油价是最便宜的
					//所以 将油加满，直接行驶到 j-1站
					j--;
					break;
				}
				if(Pi[j] <= Pi[i]){
					break;
				}		
			}
			//System.out.print("第" + i + "个加油站：   res = " + res + "  j = " + j);
			
			if(Pi[j] <= Pi[i]){
				//找到了一个油价比当前加油站i的油价便宜，并且能够到达此加油站
				
				if(res * D2 >= (Di[j] - Di[i])){//油箱的油够用
//犯了一个低级错误，提前将i 赋值 为  j，导致计算res的算式中，两元素相减恒为 0					
//					i = j;
					res = res - (Di[j] - Di[i]) / D2;
					i = j;
					//System.out.println("  油够用，不加");
				}else{
					//将油加到刚刚好能到达加油站j
					fee = fee + ((Di[j] - Di[i]) / D2 - res) * Pi[i];
					//System.out.println("  加油 到 " + j );
					//模拟行驶到加油站j
					i = j;
					res = 0;//油刚刚好用完
				}

			}else{
				//在汽车行驶的最大距离中，没有比现在更便宜的加油站
				//在当前站把油加满，开往下一站
				fee = fee + (C - res) * Pi[i];
				
				res = C - (Di[i+1] - Di[i]) / D2;
				i = i + 1;
				//System.out.println("  加满,可以到" + j);
//				res = C - (Di[j] - Di[i]) / D2;
//				i = j;
			}
		}
		
		System.out.printf("%.2f",fee);
	}

}
