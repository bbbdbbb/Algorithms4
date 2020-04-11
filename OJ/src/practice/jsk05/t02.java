package practice.jsk05;

import java.util.Arrays;

public class t02 {

	private static char[] chs;

	public static void main(String[] args) {

		String S = "ralvwwieqlinvkfylspfzexlezowlwfvtrstxtkewtakkcozsgonninupqvgtyremrwhvstsrspsfqppokrxqquloeibmxloksoseentrnkxvoq";
		chs = S.toCharArray();
		Arrays.sort(chs);
		System.out.println(String.valueOf(chs));
		
		for(int i = 0; i < chs.length; i++){
			if(chs[i] == 'z'){
				break;
			}
			if(chs[i] == chs[i+1]){
				
				chs[end(i) - 1] = (char) (chs[i] + 1);
				chs[i] = '0';
			}
		}
		System.out.println(String.valueOf(chs));
		System.out.println("zzzzzzywusqpnmljd");
		
		
		
	}

	private static int end(int i) {
		
		char ch = chs[i];
		for(;i < chs.length; i++){
			if(ch == chs[i]){
				continue;
			}else{
				break;
			}
		}
		return i;
	}

}
