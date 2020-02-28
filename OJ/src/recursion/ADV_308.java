package recursion;

import java.util.Scanner;

/**   
 * 算法提高 递归输出
 * http://lx.lanqiao.cn/problem.page?gpid=T594
*    
* 项目名称：OJ   
* 类名称：ADV_308   
* 类描述： 莫名其妙的递归题，没有意义  
*
	编写递归函数，将组成整数的所有数字逐个输出，每个数字后面加上一个减号“-”，例如对于整数123，该函数将输出1-2-3- 。
	
* 创建人：bbbdbbb   
* 创建时间：2020年2月28日 下午8:54:04   
* @version        
*/
public class ADV_308 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		String str = Integer.toString(n);
		
		String end = f(str);		
		System.out.print(end);

	}

	private static String f(String str) {
		
		if(str.length()==1)			return str+"-";
		else 						return str.charAt(0)+"-"+f(str.substring(1));
	}

}
