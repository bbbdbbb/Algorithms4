package chapter1;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_1_06   
* 类描述：第一章，习题1.1.06,下面这段程序会打印出什么。  
* 创建人：bbbdbbb   
* 创建时间：2020年1月18日 下午8:48:51   
* @version        
*/
public class P1_1_06 {

	public static void main(String[] args) {
		int f=0;
		int g=1;
		System.out.println("f="+f+"  g="+g);
		for(int i=0;i<=15;i++){
			//System.out.println(f);
			f=f+g;
			g=f-g;
			System.out.println("f="+f+"  g="+g);
		}
	}

}
