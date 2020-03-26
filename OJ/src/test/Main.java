package test;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

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
					double tem = res * D2;
					s = s - tem; //s - 油箱剩余的油能行驶的路程
					ans += (s / D2) * ps[i];
					//不要忘记加油
					res += s / D2;
					
					
					System.out.println("2打桩" + i +" : ans = " + ans + "   ps[i] = " + ps[i] + "    s = "+s  + "  res = "+res);

				}
			}else{//在第i个加油站 加满C升油 不能 到达第j个加油站
				//把油加满
				ans += (C - res) * ps[i];
				res = C;
				System.out.println("3打桩" + i +" : ans = " + ans + "   ps[i] = " + ps[i]);
			}
			
			
			//模拟汽车从加油站i 行驶到 加油站i+1 消耗油的过程
			if(j + 1 == i){
				res = 0;
			}else{
				res -= (ds[i+1] - ds[i]) / D2;
			}
		}
		
			
		

		if(i == N+1){//成功到达终点
			System.out.printf("%.2f",ans);
		}else{//中间break 了
			System.out.println("No Solution");
		}
		
		System.out.printf("%.2f",0.156);
		
		//计时，在提交答案的时候要删除
		//long endMili=System.currentTimeMillis();
		//System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}
	
	public class node{
		public int k;
		public int a1;
		public int x;
		public int y;
		public int m;
	}
	
	//创建node的比较器
	public class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.a1 - o2.a1;
		}
		
	}
	
	
}