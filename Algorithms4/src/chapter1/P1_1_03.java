package chapter1;

import java.util.Scanner;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_1_03   
* �������� ��һ�£�ϰ��1.1.03,�������еõ������������ж��Ƿ�ȫ����ͬ��     
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��16�� ����11:31:02   
* @version        
*/
public class P1_1_03 {

	public static void main(String[] args) {
		int i = 0;
		int[] arr = new int[3];
		Scanner scan = new Scanner(System.in);
		while(i<3){
			if(scan.hasNextInt()){
				arr[i] = scan.nextInt();
			}
			i++;
		}
		
		if(arr[0] == arr[1] && arr[1] == arr[2])	System.out.println("equal");
		else	System.out.println("not equal");
	}

}
