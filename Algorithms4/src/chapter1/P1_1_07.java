package chapter1;

import edu.princeton.cs.algs4.StdOut;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_1_07   
* 类描述：第一章，习题1.1.07，给出下列代码段打印的值 
* 创建人：bbbdbbb   
* 创建时间：2020年1月18日 下午9:04:04   
* @version        
*/
public class P1_1_07 {

	public static void main(String[] args) {
		//a. 
		double t = 9.0;
		while(Math.abs(t-9.0/t) > .001){
			t = (9.0/t + t) / 2.0;
		}
		StdOut.printf("%.5f\n", t);//3.00009
		
		//b.
		int sum = 0;
		for(int i=1;i<1000;i++){
			for(int j=0;j<i;j++){
				sum++;
			}
		}
		StdOut.println(sum);//499500
		
		//c.
		int sum2 = 0;
		for(int i=1;i<1000;i*=2){
			for(int j=0;j<1000;j++){
				sum2++;
			}
		}
		StdOut.println(sum2);//11000
	}

}
