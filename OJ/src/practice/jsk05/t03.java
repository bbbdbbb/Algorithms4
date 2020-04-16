package practice.jsk05;

import java.util.Scanner;

/** �����ģ����    ---- ��ѧ����
 * 	��ţ��
 * 	https://www.jisuanke.com/course/6497/467057  
 * 
 	��Ŀ��
 һ����Ҫ�� n ��ţ�ţ�ţ�������棬ÿ����Ҫ��5���ӡ������� k ������ÿ����һ��ֻ�ܼ�����ţ��
 �� �� n ��ţ�����������ʱ��
 	���룺 
998244353  10    n ,  k
 	�����
499122180

	���룺
30 10
	�����
15

	���룺
1 10
	�����
10


*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�t03   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��12�� ����10:38:57   
* @version        
*/
public class t03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = 0;
		
		/*
		 * ˼·��
		 * 1.�� n <= 2k ʱ������Ȼû�з�����Ҳ��������Ρ� => t = 2�� * 5����
		 * 2.�� n  > 2k ʱ�� ��nȡ2k�����У�n = s * 2k + m, ����s���̣�m������
		 * 	(1).�� m = 0 ʱ��ÿ�ι����ܷ���2k��ţ�ţ�û�в����ռ䡣 => t = s * 2�� * 5����
		 *  (2).�� m <= kʱ�� ����mС��һ�ο��Լ��ţ��������һ�룬����2k��ţ�ų�������
		 *  	a.ǰ��� (s - 1) * 2k ��ţ�ž�������������ʱ(s - 1) * 2�� * 5����
		 *  	b.��2k ��ţ�ŵ����棬��ʱ5����
		 *  	c.��m��ţ�ŵ����棬��2k-m ��ţ�ŵķ��棬��ʱ5����
		 *  	d.��ʣ�� 2m ��ţ�ŵķ��棬 ��ʱ5����
		 *  	=> t = s * 2�� * 5���� + 5����
		 *  (3).��m > k ʱ��û�в����ռ�  => t = s * 2�� * 5���� + 10����
		 */
		if(n <= 2 * k){ // t = 2 * 5
			t = 2 * 5;
		}else{// n > 2k
			if(n % (2 * k) == 0){
				t = n / (2 * k) * 2 * 5;
			}else if(n % (2 * k) <= k){
				t = n / (2 * k) * 2 * 5 + 5;
			}else{
				t = n / (2 * k) * 2 * 5 + 10; 
			}
		}
		
		System.out.println(t);
		
	}

}