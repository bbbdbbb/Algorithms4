package greedy;

import java.util.Scanner;

/** 贪心算法
 * 算法训练 旅行家的预算 
 * http://lx.lanqiao.cn/problem.page?gpid=T75 
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
					System.out.println("1打桩" + i +" : 不用加油     j = " + j + "   res = " + res +"     ds[j] = " + ds[j] + "   ds[i]"+ds[i]);
				}else{//需要加适量的油才可以到达第j个加油站
					double s = ds[j] - ds[i];
					double tem = (double)Math.round((res * D2)*1000)/1000;
					s = (double)Math.round((s - tem) * 1000) / 1000; //s - 油箱剩余的油能行驶的路程
					ans = (double)Math.round(( ans + (double)(Math.round((s / D2) * ps[i] * 1000)) /1000) *1000) / 1000;
					//不要忘记加油
					res = (double)Math.round((res + (double)(Math.round((s / D2) * 1000)) / 1000) * 1000) / 1000;
					
					
					System.out.println("2打桩" + i +" : ans = " + ans + "   ps[i] = " + ps[i] + "    s = "+s  + "  res = "+res);

				}
			}else{//在第i个加油站 加满C升油 不能 到达第j个加油站
				//把油加满
				ans = (double)Math.round((ans +(C - res) * ps[i]) * 1000) / 1000;
				res = C;
				System.out.println("3打桩" + i +" : ans = " + ans + "   ps[i] = " + ps[i]);
			}
			
			
			//模拟汽车从加油站i 行驶到 加油站i+1 消耗油的过程
			if(j + 1 == i){
				res = 0;
			}else{
				res = (double)Math.round((res - (double)(Math.round((ds[i+1] - ds[i]) / D2 * 1000)) / 1000) * 1000) /1000;
			}
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
		
		if(i == N+1){//成功到达终点
			System.out.printf("%.2f",ans);
		}else{//中间break 了
			System.out.println("No Solution");
		}
		
	}

}
