package practice.ssmn;

import java.util.Scanner;

/**  凯撒密码 
*    
* 项目名称：OJ   
* 类名称：F   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月18日 上午9:46:35   
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
