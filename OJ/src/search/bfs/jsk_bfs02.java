package search.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**  计蒜客学习中心   广度优先搜索bfs 
 * 	一维跳棋
 * 	https://www.jisuanke.com/course/6497/341239
 * 	思路：
 * 		同时利用队列和hashmap来解决问题。队列就是bfs的基础
 * 		hashmap的key是某一时刻棋子的位置，value是此时刻的前一时刻的棋子位置
 * 		当N = 3时，第一个kv就是（"WWW BBB","s"）
 * 		第二层的kv就是（"WW WBBB","WWW BBB"）和（"WWWB BB","WWW BBB"）
 * 
 * 		最后，当出现了 "BBB WWW"就结束bfs，便可以倒退bfs的路线了
 * 
 * 	2  ——》  "WW BB"  可能的步骤如下：
 * 	"W WBB"  "WBW B"  "WBWB "   "WB BW"  " BWBW"  	"B WBW"   "BBW W"  "BB WW"
 * 	
 
	输入
4
	输出
4 6 7 5 3
2 4 6 8 9
7 5 3 1 2
4 6 8 7 5
3 4 6 5

*    
* 项目名称：OJ   
* 类名称：jsk_bfs02  
* 创建人：bbbdbbb   
* 创建时间：2020年4月10日 下午8:32:54   
* @version        
*/
public class jsk_bfs02 {
	
	private static int[] ans = new int[1000000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, String> hm = new HashMap<>(); 
		LinkedList<String> q = new LinkedList<String>();
		String prev = null;
		
		//构建跳棋的初始状态
		String str = "";
		String end = "";
		for(int i = 0; i < N; i++){
			str += "W" ;
			end += "B";
		}
		str += " ";
		end += " ";
		for(int i = 0; i < N; i++){
			str += "B";
			end += "W";
		}
		
		q.add(str);
		hm.put(str, "s");
		while(!q.isEmpty()){
			String now = q.poll();
			
			//结束
			if(now.equals(end)){
				break;
			}
			
			//没有结束，bfs
			char[] chs = now.toCharArray();
			int index = now.indexOf(" ");
			
			
			//空格向左移动
			if(index - 1 >= 0){
				chs = ex(chs,index,index-1);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//没有走过这步
					hm.put(newStr, now);
					q.add(newStr);
				}
				//恢复 数组chs
				chs = ex(chs,index,index-1);
			}
			
			//空格向右移动
			if(index + 1 < (2 * N + 1)){
				chs = ex(chs,index,index+1);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//没有走过这步
					hm.put(newStr, now);
					q.add(newStr);
				}
				//恢复 数组chs
				chs = ex(chs,index,index+1);
			}
			

			
			//空格向右边跳
			if(index + 2 < (2 * N + 1) && chs[index + 1] != chs[index + 2]){
				chs = ex(chs,index,index+2);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//没有走过这步
					hm.put(newStr, now);
					q.add(newStr);
				}
				//恢复 数组chs
				chs = ex(chs,index,index+2);
			}
			
			//空格向右边跳
			if(index - 2 >= 0 && chs[index - 1] != chs[index - 2]){
				chs = ex(chs,index,index-2);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//没有走过这步
					hm.put(newStr, now);
					q.add(newStr);
				}
				//恢复 数组chs
				chs = ex(chs,index,index-2);
			}
		}
		
		
//		Iterator iter = hm.entrySet().iterator();
//		while (iter.hasNext()) {
//		  Map.Entry entry = (Map.Entry) iter.next();
//		  Object key = entry.getKey();
//		  Object val = entry.getValue();
//		  System.out.println(key+"    "+val);
//		}
		
		int count = 0;
		while(!end.equals("s")){
			//System.out.println(end);
			ans[count++] = end.indexOf(" ") + 1;
			end = hm.get(end);
		}
		
		int yu5 = 1;
		for(count-=2;count >= 0; count--){
			if(yu5 % 5 != 0){
				System.out.print(ans[count] + " ");
			}else{
				System.out.println(ans[count]);
			}
			yu5++;
		}
		
	}

	
	private static char[] ex(char[] chs, int i, int j) {

		char temp = chs[i];
		chs[i] = chs[j];
		chs[j] = temp;
		
		return chs;
	}

}
