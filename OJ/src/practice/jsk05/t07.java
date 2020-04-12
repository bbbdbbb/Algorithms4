package practice.jsk05;

import java.util.Arrays;
import java.util.Scanner;

public class t07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		char[] chs = str.toCharArray();
		char ch = 'a';
		for(int i = 0; i < k; i++){
			int index = -1;
			for(int j = 0; j < chs.length; j++){
				if(chs[j] == ch){
					index = j; 
					break;
				}
			}
			
			if(index > -1){//删除
				chs[index] = '0';
			}else{
				ch = (char) (ch + 1);
				i--;//i要先减后加，保持不变，搜索新的ch 
			}
		}
		
		int len = chs.length;
		for(int i = 0; i < len; i++){
			if(chs[i] != '0'){
				System.out.print(chs[i]);
			}
		}
//		System.out.println(str);
	}

}
