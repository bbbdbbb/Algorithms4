package chapter1;

import collection.Stack;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_12   
* ��������  ��ϰ1.3.12,��Stack�������һ����̬��copy()����������һ���ַ���ջ��Ϊ�����������ظ�ջ��һ������  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��6�� ����8:53:57   
* @version        
*/
public class P1_3_12 {

	public static void main(String[] args) {
		
		Stack<String> s1 = new Stack<String>();
		s1.push("Ԫ��a");
		s1.push("Ԫ��b");
		s1.push("Ԫ��c");
		//����copy���������ַ���ջs1Ϊ�������õ�s1��һ������
		Stack<String> s2 = Stack.copy(s1);
		
		System.out.print("s1: ");
		for(String s : s2){
			System.out.print(s+" ");
		}
		System.out.print("\ns2: ");
		for(String s : s2){
			System.out.print(s+" ");
		}
	}

}
