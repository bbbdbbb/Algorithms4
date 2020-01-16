package chapter1;

import java.util.Scanner;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_1_03   
* 类描述： 第一章，习题1.1.03,从命令行得到三个参数，判断是否全都相同。     
* 创建人：bbbdbbb   
* 创建时间：2020年1月16日 下午11:31:02   
* @version        
*/
public class P1_1_03 {

	public static void main(String[] args) {
		int i = 0;
		int[] arr = new int[3];
		Scanner scan = new Scanner(System.in);
		while(i<3){
			if(scan.hasNextInt()){
				arr[i] = scan.nextInt();
			}
			i++;
		}
		
		if(arr[0] == arr[1] && arr[1] == arr[2])	System.out.println("equal");
		else	System.out.println("not equal");
	}

}
