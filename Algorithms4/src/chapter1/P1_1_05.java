package chapter1;

import java.util.Scanner;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_1_05   
* 类描述：第一章，习题1.1.05，判断double变量x和y是否严格位于0和1之间。 
* 创建人：bbbdbbb   
* 创建时间：2020年1月17日 下午11:44:21   
* @version        
*/
public class P1_1_05 {

	public static void main(String[] args) {
		int i = 0;
		Double[] arr = new Double[2];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入x和y的值：");
		while(i<2){
			if(scan.hasNextDouble()){
				arr[i] = scan.nextDouble();
			}
			i++;
		}
		
		System.out.println("x和y是否严格位于0和1之间：");
		if(arr[0]<1 && arr[0]>0 && arr[1]<1 && arr[1]>0)	System.out.println("true");
		else	System.out.println("false");		
	}

}
