package chapter1;

import java.util.Scanner;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_1_05   
* ����������һ�£�ϰ��1.1.05���ж�double����x��y�Ƿ��ϸ�λ��0��1֮�䡣 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��17�� ����11:44:21   
* @version        
*/
public class P1_1_05 {

	public static void main(String[] args) {
		int i = 0;
		Double[] arr = new Double[2];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������x��y��ֵ��");
		while(i<2){
			if(scan.hasNextDouble()){
				arr[i] = scan.nextDouble();
			}
			i++;
		}
		
		System.out.println("x��y�Ƿ��ϸ�λ��0��1֮�䣺");
		if(arr[0]<1 && arr[0]>0 && arr[1]<1 && arr[1]>0)	System.out.println("true");
		else	System.out.println("false");		
	}

}
