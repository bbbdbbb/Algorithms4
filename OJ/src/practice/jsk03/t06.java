package practice.jsk03;

import java.util.Scanner;

public class t06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String s1 = scan.next();
		String s2 = scan.next();
		
		
		int a = 0,b = 0,e = 0;
		
		for(int i = 0 ; i < n; i++){
			if(s1.charAt(i) == s2.charAt(i)){
				e++;
			}else if(s1.charAt(i) == 'S'){
				if(s2.charAt(i) == 'R'){
					b++;
				}else{
					a++;
				}
			}else if(s1.charAt(i) == 'R'){
				if(s2.charAt(i) == 'P'){
					b++;
				}else{
					a++;
				}
			}else if(s1.charAt(i) == 'P'){
				if(s2.charAt(i) == 'S'){
					b++;
				}else{
					a++;
				}
			}
		}
		
		
		System.out.println(""+a+" "+b+" "+e);
	}

}
