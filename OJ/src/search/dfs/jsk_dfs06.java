package search.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** �����ѧϰ����   dfs��֦
 * 	��������������
 * 	 https://www.jisuanke.com/course/6497/341236
 *
	���룺
3
10
100
1000

	�����
6
60
840

*	��û�м�֦������£�����������԰��������ǵ���������������س�ʱ
*    
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dfs06   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��8�� ����10:38:31   
* @version        
*/
public class jsk_dfs06 {

	public static Set<String> hs = new HashSet<String>();
	private static int[] nums;



	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		nums = new int[n];
		
		for(int i = 0; i < n; i++){
			nums[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++){
			f(nums[i]);
		}
		
		
	
	}



	private static void f(int num) {

		int ans = 0;
		int cnt = 0;
		for(int i = num / 2; i <= num; i++){
			
			int tem = 0;
			for(int j = 1; j <= Math.sqrt(i); j++){
				if(i % j == 0){ // i �������� j
					if(j * j == i){
						tem++;
					}else{
						tem += 2;
					}
					
				}
			}
			if(tem > cnt){
				ans = i;
				cnt = tem;
			}
			
		}
		System.out.println(ans);
		
	}

	
	

	
}
