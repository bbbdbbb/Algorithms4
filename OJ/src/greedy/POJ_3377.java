package greedy;

import java.util.Scanner;

/** 贪心算法  思路简单，实现细节很多
 * Best Cow Line, Gold
 * http://bailian.openjudge.cn/practice/3377/
*    
* 项目名称：OJ   
* 类名称：POJ_3377   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月9日 下午4:22:10   
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
		//贪心选择，从头和尾中选择一个字典序列小的首字母
		while(pri <= end){
			boolean left = false;//判断 获取 头部或尾部的首字母
			
			for(int i = 0; pri + i <= end; i++){
				if(chs[pri+i] < chs[end-i]){
					left = true;//获取 头部的首字母
					break;
				}else if(chs[pri+i] > chs[end-i]){
					left = false;
					break;
				}

			}
			
			if(count==80){//80个字母换行
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
