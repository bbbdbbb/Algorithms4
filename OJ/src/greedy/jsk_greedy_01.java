package greedy;

import java.util.Scanner;

/** 计蒜客学习中心	贪心算法
 * 	奶酪工厂
 * 	https://www.jisuanke.com/course/6497/341060  
在N个星期里，工厂要生产产品满足用户，用户本周需要的产品可以从工厂生产，也可以用仓库里存储的产品（仓库容量无限，但是如果修改题目为仓库容量有限又该如何解题?）
每个周产品的生产成本单价会发生变化，但是仓库储存产品的单价S不会发生改变
求N个周的最少成本？
	输入： N周数  S仓库储存单价
		每一周 的 产品成本  和用户需求数量
4 5
88 200
89 400
97 300
91 500	
	输出：
126900

*    
* 项目名称：OJ   
* 类名称：jsk_greedy_01   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月24日 上午10:41:06   
* @version        
*/
public class jsk_greedy_01{
    
    public static long[] cost;
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long S = scan.nextLong();
        cost = new long[N];
        
        long sum = 0L; 
        long temp = 1005000L;
        for(int i = 0; i < N; i++){
            cost[i] = scan.nextLong();
            long num = scan.nextLong();
            
            //选择最便宜的价格：生产成本+保存成本
            //一种是本周直接生产价格最低：cost[j]
            //一种是上周的生产方式的价格加上保存一周的价格最低：temp + S
            //上周的生产方式的价格可以是上上周的保存下来的产品，
            //在上周已经计算了保存的成本，所以在这周只需再加上一周的保存成本
            temp = Math.min(cost[i] , temp + S);
            
            sum = sum + temp * num;
        }
        
        System.out.print(sum);
    }
}
