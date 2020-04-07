package search.dfs;

import java.util.Scanner;

/** 抽象深度优先搜索
 *  计蒜客抽象深度优先搜索第一题
 *  
 *   题目：
 *   输入n，表示有n根木棍
 *   在输入n个整数，分别表示n根木棍的长度
 *   判断m根木棍能否拼凑成一个等边三角形
 *   
 *  创建时间：2020年3月30日 上午10:01:37    
 *  代码优化：2020年3月31日   -->  通过记录下一个木棍的位置，减少dfs()中for循环的次数。本质上，是去重，将(1,4),(2,3),(5)
 *  				   -->  本质上，是去重.原来将(1,4),(2,3),(5) 和 (1,4),(5),(2,3)因为顺序不同看成不同的选择
 *  				   -->  优化后，将不会重复判断
*    
* 项目名称：OJ   
* 类名称：jsk_abstract_dfs01   
* 类描述：   
* 创建人：bbbdbbb   
* 
* @version        
*/
public class jsk_abstract_dfs01 {

	private static int[] item;
	private static int s = 0;//记录所有木棍长度的总和
	private static boolean flag = false;//判断能否成功拼成等边三角形
	private static boolean[] vis;//用于记录木棍有没有使用
	private static int n;
	
	public static int test = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		item = new int[n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			item[i] = scan.nextInt();
			s += item[i];
		}
		
		//System.out.println("s = " + s);
		
		//剪枝：
		//因为要使用全部木棍，木棍的长度总和必须是三的倍数
		if(s % 3 != 0){
			System.out.println("no");
		}else{
			dfs2(0,0,0);
			if(flag){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
			
		}
		
		System.out.println(test);
		
	}

	private static void dfs(int count, int sum) {

		if(flag){
			return;
		}
		
		if(count == 3){
			flag = true;

			return;
		}
		
		if(sum == s / 3){
			dfs(count + 1, 0);
			return;
		}
		
		for(int i = 0; i < n; i++){
			test++;
			
			if(!vis[i]){
				vis[i] = true;
				//System.out.println("for>  i = " + i +" count = "+count + "  sum =  " +(sum + item[i]));
				dfs(count, sum + item[i]);
				vis[i] = false;
			}
		}
		
	}
	
	

	/**
	 * 代码优化，减少重复！！！
	 * 优化的的关键是这里，以前写的是dfs(count + 1, 0,count)。直接传count会导致结果错误
	 * 列如：
	 * 在“1 2 3 4 5”中选择了‘1’ 和‘4’后理论上说应该从‘2’开始
	 * 如果按照dfs(count + 1, 0,count)的话，在“1 2 3 4 5”中选择了‘1’ 和‘4’后，
	 * 就只能选择‘5’，导致不能正确判断
	 * 
	 * @param count 已经完成拼凑的木棒数量
	 * @param sum 当前所拼凑木棒的长度（当sum == s / 3  时完成当前木棒的拼凑）
	 * @param index 下一个应该搜索的木棍的索引
	 */
	private static void dfs(int count, int sum, int index) {
		test++;
		
		if(flag){
			return;
		}
		
		if(count == 3){
			flag = true;
			return;
		}
		
		if(sum == s / 3){
			dfs(count + 1, 0,0);//优化的的关键是这里，以前写的是dfs(count + 1, 0,count)。直接传count会导致结果错误
								//列如：
								//在“1 2 3 4 5”中选择了‘1’ 和‘4’后理论上说应该从‘2’开始
								//因为操作麻烦不能每次都精准的找到重新开始的位置，所以每当拼凑成功一根木棒时，从头开始重新搜索其他木棍
								//如果按照dfs(count + 1, 0,count)的话，在“1 2 3 4 5”中选择了‘1’ 和‘4’后，
								//就只能选择‘5’，导致不能正确判断
			return;
		}
		
		for(int i = index; i < n; i++){
			
			if(!vis[i]){
				vis[i] = true;
				//System.out.println("for>  i = " + i +" count = "+count + "  sum =  " +(sum + item[i]));
				dfs(count, sum + item[i],i+1);
				vis[i] = false;
			}
		}
		
	}

	
	//使用搜索枚举
	private static void dfs2(int count, int sum, int index) {

		if(flag){
			return;
		}
		
		if(index >= n){
			return;
		}
		
		if(count == 3){
			flag = true;
			return;
		}
		
		if(sum == s / 3){
			dfs(count + 1, 0,0);//优化的的关键是这里，以前写的是dfs(count + 1, 0,count)。直接传count会导致结果错误
								//列如：
								//在“1 2 3 4 5”中选择了‘1’ 和‘4’后理论上说应该从‘2’开始
								//因为操作麻烦不能每次都精准的找到重新开始的位置，所以每当拼凑成功一根木棒时，从头开始重新搜索其他木棍
								//如果按照dfs(count + 1, 0,count)的话，在“1 2 3 4 5”中选择了‘1’ 和‘4’后，
								//就只能选择‘5’，导致不能正确判断
			return;
		}
		
		//选 当前  木棍
		if(!vis[index]){
			dfs2(count,sum + item[index],index + 1);
		}
		//不选 当前 木棍
		dfs2(count,sum,index+1);
		
	}
}
