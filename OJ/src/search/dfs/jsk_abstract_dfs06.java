package search.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**  ��������������� 
 * 	����ͳ��������������������
 * 	https://www.jisuanke.com/course/6497/341082
 * 	
 * 	��Ŀ��
 * 		������  (���P1037������)
 * 
 * 	<<< 2020��4��2�� >>>
 * 	˼·�����⣬��nС��ʱ�������ȷ����𰸣���n���ʱ�������쳣
 * 
 * 	���룺
11111111111111111111 2
1 2
2 1

 * 	�쳣��Ϣ��
Exception in thread "main" java.lang.StackOverflowError
	at java.util.HashMap.hash(Unknown Source)
	at java.util.HashMap.containsKey(Unknown Source)
	at java.util.HashSet.contains(Unknown Source)
	
 * 	Ӧ���Ƕ�ջ����ˣ������Ұѱ���������Ϊ��̬�����ˣ����������
 *  ���п�����hashset��size������Χ�ˣ�   =>  ����hashset����������

 * 	  	<<< 2020��4��2��  ��һ���޸�>>>
 * 	ǰ������Ϊ�ݹ�̫����������¶�ջ�����
 * 	��dfs()�����������һ��index���������ڼ�¼��һ��Ӧ���ж��Ƿ���Ϲ�������ֵ�����
 * 
 * 	�����ȷ���������г�ʱ���Ժ����Ż�����




*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_abstract_dfs06   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��2�� ����9:11:08   
* @version        
*/
public class jsk_abstract_dfs06 {

	private static String n;
	private static int k;
	private static int[][] rule;
	public static int ans = 0;
	public static Set<String> hs = new HashSet<String>();

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		
		Scanner scan = new Scanner(System.in);
		n = scan.next();
		k = scan.nextInt();
		rule = new int[k][2];
		for(int i = 0; i < k; i++){
			rule[i][0] = scan.nextInt();
			rule[i][1] = scan.nextInt();
		}
		
		dfs(n,0);
		System.out.println(hs.size());
		
		
		System.out.println("ʱ�䣺" + ( System.currentTimeMillis() -start));
		
	}

	private static void dfs(String n, int index) {
		//System.out.println(n);
		if(index == n.length())
			return;
		
		if(hs.contains(n)){
			return;
		}else{
			hs.add(n);
		}
		

		char[] ch = n.toCharArray();
		for(int i = index; i < ch.length; i++){
			int number = ch[i] - '0';
			//System.out.println(number);
			for(int j = 0; j < k; j++){
				if(rule[j][0] == number){
					ch[i] = (char) ('0' + rule[j][1]);
					String str = String.valueOf(ch);
					dfs(str,i);
					
					ch[i] = (char) ('0' + rule[j][0]);
					//break;
				}
			}
		}
	}

}
