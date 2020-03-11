package practice.wbwp02;

import java.util.ArrayList;
import java.util.List;

/** 细节题  
*    
* 项目名称：OJ   
* 类名称：p04   
* 类描述：   判断一个幸运数59084709587505l的编号
* 			幸运数的因子只包含3，5和7
* 			前10个幸运数字是：
* 			3 5 7 9 15 21 25 27 35 45
* 			第11个幸运数字是：
* 			49
* 
* 创建人：bbbdbbb   
* 创建时间：2020年3月11日 下午4:19:09   
* @version        
*/
public class p04 {

	public static void main(java.lang.String[] args) {
		long MAX =  59084709587505l;
		int count = 0;
		//第一个确定的数是 3^0+5^0+7^0 = 1  因为‘1’并不是幸运数，所以这里多加了一次
		//在for循环中的判断条件都是  ‘ < MAX ’ 所以少数了一种情况（等于   MAX）
		//多一次，少一次，刚好抵消
		for ( long i = 0; Math.pow(3,i) < MAX; ++i)
			for ( long j = 0; Math.pow(5,j)*Math.pow(3,i) < MAX; ++j)
				for ( long k = 0; Math.pow(7,k)*Math.pow(5,j)*Math.pow(3,i) < MAX; ++k)
						count ++;
		
		System.out.println(count);		
	}
	
	
	/*
	 * 想到的 暴力破解方法，复杂度度太高，算不出来结果，耗时
	 */
//	public static void main(String[] args) {
//
//		int count = 2;
//		long num = 7;
//		List<Long> list = new ArrayList<>(1000);
//		list.add(3L);
//		list.add(5L);
//		list.add(7L);
//		long N = 59084709587505L;
//		
//		
//		loop1: while(++num<=N){
//			long tempNum = num;//临时保存num的值
//			if(num%2 == 0)		continue;
//			if(num%3 != 0 && num%5 != 0 && num%7 != 0)		continue;
//			
//			int temp = count;
//			//判断num的因数是不是3.5.7
//			while(true){
//				if(tempNum == 1){
//					System.out.println(num+" 是第 "+(count+1)+" 个幸运数字");
//					list.add(num);
//					count++;
//					break;
//				}
//				if(temp == -1){
//					continue loop1;
//				}
//				
//				//num 的因数 包含幸运数
//				if(tempNum%list.get(temp)==0){
//					tempNum = tempNum/list.get(temp);
//				}else{
//					temp--;
//				}
//			}
//		}
//		
//		
//	}

}
