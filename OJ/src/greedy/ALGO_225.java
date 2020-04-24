package greedy;

import java.util.Scanner;

/** 
 * ̰���㷨   ���� ��ÿ�ζ�ѡ���ֵ��   ʹ�õ��Ǳ��������������ֵ����ѧϰ����Ӧ�ļ��Ϻ����Ż�����  
 * �㷨ѵ�� ʯ����Ϸ
 * http://lx.lanqiao.cn/problem.page?gpid=T573
*  
* ����������
*   ʯ����Ϸ�Ĺ������£�
*����������n��ʯ�ӣ�ÿ�β�����ѡȡ����ʯ�ӣ�ʯ�Ӹ����ֱ�Ϊx��y���������Ǻϲ��������ĵ÷ּ�Ϊ(x+1)��(y+1)���Ե��ϵ�ʯ�Ӷѽ��в���ֱ��ֻʣ��һ��ʯ��ʱֹͣ��Ϸ��
*����������������Ϸ�����в������ܵ÷ֵ����ֵ�Ƕ��٣�   
*    
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_225   

* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��25�� ����4:33:53   
* @version        
*/
public class ALGO_225 {
	
	public static long[] nums;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		nums = new long[n]; 
		
		for(int i = 0; i < n; i++){
			nums[i] = scan.nextLong();
		}
		
		long ans = 0;
		int max1 = 1;//�δ�ֵ  index
		int max2 = 0;//���ֵ
		while(n > 1){
			if(nums[max1] > nums[max2]){
				swap(max1,max2);
				int temp = max1;
				max1 = max2;
				max2 = temp;
			}
			
			/*
			 * �ҵ�ǰʯ������Ŀ�������ֵ�ʹδ�ֵ
			 */
			for(int i = 1; i < n; i++){
				//���ڴδ�ֵ����¼����
				if(nums[i] > nums[max1]){
					max1 = i;
				}
				//���nums[i]���ڴδ�ֵ�������Ѿ��������¼������
				//���� �� Ҳ�п��� ����ǰ��¼�����ֵ�����������������һ���ж�
				if(nums[max1] > nums[max2]){
					int temp = max1;
					max1 = max2;
					max2 = temp;
				}				
			}
			
//			
//			System.out.println("��׮"+n);
//			for(int i = 0; i < n; i++){
//				System.out.print(nums[i] + "  ");
//			}
//			System.out.println(nums[max1] + " and "+ nums[max2]);
			
			ans += (nums[max1] + 1) * (nums[max2] + 1);
			nums[max2] += nums[max1];
			if(max2 == n-1){
				swap(max1,max2);
				int temp = max1;
				max1 = max2;
				max2 = temp;
				swap(0,max2);
			}else{
				swap(0,max2);
				swap(max1,n-1);
			}
			
			max2 = 0;
			max1 = 1;
			n--;
		}
		
		System.out.println(ans);
		
	}
	
	
	public static void swap(int a,int b){
		long temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
