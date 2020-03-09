package greedy;

import java.util.Scanner;

/** ̰���㷨  ˼·�򵥣�ʵ��ϸ�ںܶ�
 * Best Cow Line, Gold
 * http://bailian.openjudge.cn/practice/3377/
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�POJ_3377   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��9�� ����4:22:10   
* @version        
*/
public class POJ_3377 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		int count = 0;
		int N = scan.nextInt();
//		scan.nextLine();
		char[] chs = new char[N];
		for(int i = 0; i < N; i++){			
			chs[i] = scan.next().charAt(0);
		}
		
		int pri = 0;
		int end = N-1;
		//̰��ѡ�񣬴�ͷ��β��ѡ��һ���ֵ�����С������ĸ
		while(pri <= end){
			boolean left = false;//�ж� ��ȡ ͷ����β��������ĸ
			
			for(int i = 0; pri + i <= end; i++){
				if(chs[pri+i] < chs[end-i]){
					left = true;//��ȡ ͷ��������ĸ
					break;
				}else if(chs[pri+i] > chs[end-i]){
					left = false;
					break;
				}

			}
			
			if(count==80){//80����ĸ����
				System.out.println();
				count=0;
			}
			
			
			if(left){				
				System.out.print(chs[pri++]);
				count++;
			}
			else{
				System.out.print(chs[end--]);
				count++;
			}
		}
		
		System.out.println();
		scan.close();
	
	}
}
