package search.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**  抽象深度优先搜索 
 * 	计蒜客抽象深度优先搜索第六题
 * 	https://www.jisuanke.com/course/6497/341082
 * 	
 * 	题目：
 * 		产生数  (洛谷P1037产生数)
 * 
 * 	<<< 2020年4月2日 >>>
 * 	思路有问题，当n小的时候可以正确输出答案，当n大的时候会出现异常
 * 
 * 	输入：
11111111111111111111 2
1 2
2 1

 * 	异常信息：
Exception in thread "main" java.lang.StackOverflowError
	at java.util.HashMap.hash(Unknown Source)
	at java.util.HashMap.containsKey(Unknown Source)
	at java.util.HashSet.contains(Unknown Source)
	
 * 	应该是堆栈溢出了，但是我把变量都设置为静态变量了，还会溢出吗？
 *  还有可能是hashset的size超出范围了？   =>  不是hashset的容量超了

 * 	  	<<< 2020年4月2日  第一次修改>>>
 * 	前面是因为递归太多次数，导致堆栈溢出，
 * 	在dfs()方法中添加了一个index变量，用于记录下一个应该判断是否符合规则的数字的索引
 * 
 * 	结果正确，但是运行超时，以后再优化代码




*    
* 项目名称：OJ   
* 类名称：jsk_abstract_dfs06   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月2日 下午9:11:08   
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
		
		
		System.out.println("时间：" + ( System.currentTimeMillis() -start));
		
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
