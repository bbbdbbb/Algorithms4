package recursion;

import java.util.Scanner;

/**   
 * �㷨��� �ݹ����
 * http://lx.lanqiao.cn/problem.page?gpid=T594
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_308   
* �������� Ī������ĵݹ��⣬û������  
*
	��д�ݹ麯�������������������������������ÿ�����ֺ������һ�����š�-���������������123���ú��������1-2-3- ��
	
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��28�� ����8:54:04   
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
