package search.dfs;

import java.util.Scanner;

/** ���ѵļ�֦����
 * 	������
 * 	https://www.jisuanke.com/course/6497/341234
 * 	˼·��
 * 	������Integer��toBinaryString()�ķ���,������tempת���ɶ�����
 * 	������String �� parseInt()�������������Ƶ��ַ���ת�������֣������ơ�1011��ֱ�Ӿͱ����ʮ���Ƶġ�1011������ һǧ��һʮһ�������ǡ�11����
 * 	����ж��ܷ�n�������ܾ�ֹͣwhileѭ�� 
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dfs04   
* �������� �����ѧϰ����  ���ѵļ�֦����  ��һ��  ������  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��3�� ����4:05:07   
* @version        
*/
public class jsk_dfs04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp = 1;
		
		String bStr = Integer.toBinaryString(temp);
		
		while(Integer.parseInt(bStr) % n != 0){
			temp ++;
			bStr = Integer.toBinaryString(temp);
		}
		
		System.out.println(bStr);
		
	}

}
