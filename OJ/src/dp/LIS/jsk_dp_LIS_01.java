package dp.LIS;

import java.util.Scanner;

/**  �����ѧϰ����	����ֶκ�
 * 	 ��ͷ��������ֶκ�
 * 	https://www.jisuanke.com/course/6497/341113
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp_LIS_01   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��17�� ����10:50:40   
* @version        
*/
public class jsk_dp_LIS_01 {

    private static long[] ns;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ns = new long[n];
        long max = -1000000002;
        for(int i = 0; i < n; i++){
            ns[i] = sc.nextLong();
            if(ns[i] > max){
                max = ns[i];
            }
        }
        
		if(max < 0){
			System.out.println(max);
        }else{
            long sum = 0;
        	for(int i = 0; i < n; i++){
            	sum += ns[i];
            	if(sum < 0){
                	sum = 0;
                    continue;
            	}
            	if(sum > max){
               	 	max = sum;
            	}
        	}
            System.out.println(max);
        }    
        
    }


}
