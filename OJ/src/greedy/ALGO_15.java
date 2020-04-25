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
* 类名称：ALGO_15   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月26日 下午9:45:07   
* @version        
*/
public class ALGO_15 {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		double D1 = scan.nextDouble();
		double C  = scan.nextDouble();
		double D2 = scan.nextDouble();
		double P  = scan.nextDouble();
		int   N  = scan.nextInt();
		
		double[] ds = new double[N+2];//将终点也看成是一个加油站
		double[] ps = new double[N+2];
		ds[N+1] = D1;
		ps[N+1] = 0.0;//将终点这个“加油站”的油价设置为0，司机就不会因为终点的油价贵，而把油箱装满
		ds[0]   = 0.0;
		ps[0]   = P;
		for(int i = 1; i <= N; i++){
			ds[i] = scan.nextDouble();
			ps[i] = scan.nextDouble();
		}
		
		double res = 0.0;//储存当前邮箱还剩多少油
		double ans = 0.0;//结果
		int i = 0;
		for(; i <= N; i++){
			if(C * D2 < (ds[i+1] - ds[i])){
				//在第i站，把油箱加满都不能到达下一站
				break;
			}
			
			//寻找加油站i后面的价格比ps[i]低的加油站j
			int j = i + 1;
			for(; j <= N+1; j++){
				if(ps[i] <= ps[j]){
					continue;
				}else{
					break;
				}
			}
			
			if(C * D2 >= (ds[j] - ds[i])){//在第i个加油站 加满C升油 可以 到达第j个加油站
				if( (res * D2) >= (ds[j] - ds[i])){//油箱里剩余的res升油可以到达第j个加油站
					//不用在第i个加油站加油
					
					res = res - (ds[j] - ds[i]) / D2 ;
					//System.out.println("1打桩" + i +" : 不用加油     j = " + j + "   res = " + res +"     ds[j] = " + ds[j] + "   ds[i]"+ds[i]);
				}else{//需要加适量的油才可以到达第j个加油站
					double s = ds[j] - ds[i];
					double tem = res * D2;
					s = (s - tem); //s 减去 油箱剩余的油能行驶的路程
					ans =  ans + (s / D2) * ps[i];
					//不要忘记加油
					//res = res + (s / D2);
					
					//油使用完，省略计算
					res = 0;
					//System.out.println("2打桩" + i +" : ans = " + ans + "   ps[i] = " + ps[i] + "    s = "+s  + "  res = "+res);
				}
				
				//直接从加油站i 跑 到加油站j，考虑到外层for循环有一个i++，这里先减1，一会儿会加回来的
				i = j - 1;
			}else{//在第i个加油站 加满C升油 不能 到达第j个加油站
				//把油加满
				ans = ans +(C - res) * ps[i];
				res = C;
				//System.out.println("3打桩" + i +" : ans = " + ans + "   ps[i] = " + ps[i]);
				
				//行驶到下一站
				res = res - (ds[i+1] - ds[i]) / D2 ;
			}
			
			
			//模拟汽车从加油站i 行驶到 加油站j消耗油的过程
//			if(C * D2 >= (ds[j] - ds[i])){
//				res = 0;
//			}else{
//				res = res - (ds[j] - ds[i]) / D2 ;
//			}
		}
		
			
		
//第一次做题时，错误的思路：每次只比较 第i个加油站 和第i+1个加油站 之间的油价关系：
//		for(; i <= N; i++){
//			if(C * D2 < (ds[i+1] - ds[i])){
//				//在第i站，把油箱加满都不能到达下一站
//				break;
//			}
//			
//			if(ps[i] < ps[i+1]){//当前第i个加油站的油价 低于 下一个 i+1油站
//				//把邮箱加满
//				ans += (C - res) * ps[i];
//				System.out.print("打桩"+i+": "+ans);
//				
//				res = C - (ds[i+1] - ds[i]) / D2;
//				System.out.println("  res = "+res);
//			}else{//当前第i个加油站的油价 高于于 下一个 i+1油站
//				//油加到够用就行
//				double s = ds[i+1] - ds[i];
//				s = s - res * D2;//s - 油箱剩余的油能行驶的路程
//				ans += (s / D2) * ps[i];
//				System.out.println("打桩"+i+": "+ans);
//
//				res = 0;
//			}
//			
//			//模拟汽车从加油站i 行驶到 加油站i+1 消耗油的过程
//			//res = res - (ds[i+1] - ds[i]) / D2;  //代码优化： 将模拟过程直接添加到加油的时候，减少运算
//		}
//		
		if(i == N+1){//成功到达终点
			System.out.printf("%.2f",ans);
		}else{//中间break 了
			System.out.println("No Solution");
		}
		
	}

}
