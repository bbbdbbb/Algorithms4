package practice.wbwp02;

import java.util.ArrayList;
import java.util.List;

/** ϸ����  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�p04   
* ��������   �ж�һ��������59084709587505l�ı��
* 			������������ֻ����3��5��7
* 			ǰ10�����������ǣ�
* 			3 5 7 9 15 21 25 27 35 45
* 			��11�����������ǣ�
* 			49
* 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��11�� ����4:19:09   
* @version        
*/
public class p04 {

	public static void main(java.lang.String[] args) {
		long MAX =  59084709587505l;
		int count = 0;
		//��һ��ȷ�������� 3^0+5^0+7^0 = 1  ��Ϊ��1����������������������������һ��
		//��forѭ���е��ж���������  �� < MAX �� ����������һ�����������   MAX��
		//��һ�Σ���һ�Σ��պõ���
		for ( long i = 0; Math.pow(3,i) < MAX; ++i)
			for ( long j = 0; Math.pow(5,j)*Math.pow(3,i) < MAX; ++j)
				for ( long k = 0; Math.pow(7,k)*Math.pow(5,j)*Math.pow(3,i) < MAX; ++k)
						count ++;
		
		System.out.println(count);		
	}
	
	
	/*
	 * �뵽�� �����ƽⷽ�������Ӷȶ�̫�ߣ��㲻�����������ʱ
	 */
//	public static void main(String[] args) {
//
//		int count = 2;
//		long num = 7;
//		List<Long> list = new ArrayList<>(1000);
//		list.add(3L);
//		list.add(5L);
//		list.add(7L);
//		long N = 59084709587505L;
//		
//		
//		loop1: while(++num<=N){
//			long tempNum = num;//��ʱ����num��ֵ
//			if(num%2 == 0)		continue;
//			if(num%3 != 0 && num%5 != 0 && num%7 != 0)		continue;
//			
//			int temp = count;
//			//�ж�num�������ǲ���3.5.7
//			while(true){
//				if(tempNum == 1){
//					System.out.println(num+" �ǵ� "+(count+1)+" ����������");
//					list.add(num);
//					count++;
//					break;
//				}
//				if(temp == -1){
//					continue loop1;
//				}
//				
//				//num ������ ����������
//				if(tempNum%list.get(temp)==0){
//					tempNum = tempNum/list.get(temp);
//				}else{
//					temp--;
//				}
//			}
//		}
//		
//		
//	}

}
