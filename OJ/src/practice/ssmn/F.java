package practice.ssmn;

import java.util.Scanner;

/**  �������� 
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�F   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��18�� ����9:46:35   
* @version        
*/
public class F {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] chs = str.toCharArray();
		int len = str.length();
		for(int i = 0; i < len; i++){
			if(chs[i] == 'x'){
				chs[i] = 'a';
			}else if(chs[i] == 'y'){
				chs[i] = 'b';
			}else if(chs[i] == 'z'){
				chs[i] = 'c';
			}else{
				chs[i] = (char) (chs[i] + 3);
			}
		}
		
		str = String.valueOf(chs);
		System.out.println(str);
		
		
	}

}
