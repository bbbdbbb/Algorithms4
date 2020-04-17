package dp.LIS;

import java.util.Scanner;

/**  计蒜客学习中心	最大字段和
 * 	 蒜头君的最大字段和
 * 	https://www.jisuanke.com/course/6497/341113
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LIS_01   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月17日 下午10:50:40   
* @version        
*/
public class jsk_dp_LIS_01 {

    private static long[] ns;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ns = new long[n];
        long max = -1000000002;
        for(int i = 0; i < n; i++){
            ns[i] = sc.nextLong();
            if(ns[i] > max){
                max = ns[i];
            }
        }
        
		if(max < 0){
			System.out.println(max);
        }else{
            long sum = 0;
        	for(int i = 0; i < n; i++){
            	sum += ns[i];
            	if(sum < 0){
                	sum = 0;
                    continue;
            	}
            	if(sum > max){
               	 	max = sum;
            	}
        	}
            System.out.println(max);
        }    
        
    }


}
