package recursion;

import java.util.Scanner;

/**
 * �㷨ѵ�� �ݷ��ֽ�
 * http://lx.lanqiao.cn/problem.page?gpid=T72   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_12   
* ��Ŀ������  �ݹ飬������ֹ����
* 		��
*  �κ�һ����������������2���ݴη���ʾ�����磺
����137=27+23+20 
����ͬʱԼ����������������ʾ����ab �ɱ�ʾΪa��b����
�����ɴ˿�֪��137�ɱ�ʾΪ��
����2��7��+2��3��+2��0��
������һ����7= 22+2+20 ��21��2��ʾ��
����3=2+20 
�����������137�ɱ�ʾΪ��
����2��2��2��+2+2��0����+2��2+2��0����+2��0��
�������磺
����1315=210 +28 +25 +2+1
��������1315���ɱ�ʾΪ��
����2��2��2+2��0����+2��+2��2��2+2��0������+2��2��2��+2��0����+2+2��0��

*   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��28�� ����4:54:19   
* @version        
*/
public class ALGO_12 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		if(n==0){
			System.out.print(0);
		}else{
			String str = f(n);
			System.out.print(str);
		}


	}

	private static String f(int n) {
		
		String temp = "";
			
		//������ת��Ϊ������
		String binaryN = Integer.toBinaryString(n);
		int N = binaryN.length();
		System.out.println("bN:"+binaryN);
		for(int i=0;i<N;i++){
			if(binaryN.charAt(i)=='1' && i==N-1){
				temp = temp + "2(0)";
			}else if(binaryN.charAt(i)=='1' && i==N-2){
				temp = temp + "2";
			}else if(binaryN.charAt(i)=='1' && i==N-3){
				temp = temp + "2(2)";
			}else if(binaryN.charAt(i)=='1'){
				temp = temp + "2(" + f(binaryN.length()-i-1) + ")";
			}
			
			
			if(i!=N-1 && binaryN.charAt(i)=='1' && binaryN.lastIndexOf('1')>i)	temp = temp + "+";
		}
		return temp;
	}
	
	//����� ����
	private static String f2(int n) {
		
		String temp = "";
		
		//������ת��Ϊ������
		String binaryN = Integer.toBinaryString(n);
		int N = binaryN.length();
		System.out.println("bN:"+binaryN);
		
		for(int i=0;i<N;i++){//��������N�Ķ�����binaryN��ÿһλ
			if(binaryN.charAt(i)=='0'){//����binaryN��Ϊ��Ĳ���
				continue;
			}
			
			//ǰ������if�ǵݹ����ֹ����
			if(i==N-1){//2^0
				temp = temp + "2(0)";
			}else if( i==N-2){//2^1
				temp = temp + "2";
			}else if(i==N-3){//2^2
				temp = temp + "2(2)";
			}else if(binaryN.charAt(i)=='1'){//2�Ķ�η���������Ҫ�ݹ����η����ַ����ʽ
				temp = temp + "2(" + f(binaryN.length()-i-1) + ")";
			}
			
			// binaryN.lastIndexOf('1')>i ������ж��Ƿ���Ҫ  ���ϼӺ�
			if(binaryN.lastIndexOf('1')>i)	temp = temp + "+";
		}
		return temp;
	}



}
