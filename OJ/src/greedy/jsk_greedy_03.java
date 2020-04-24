package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** 计蒜客学习中心	贪心算法
 * 	蘑菇深林
 * 	https://www.jisuanke.com/course/6497/341062
	问题：
一共有n个蘑菇，蒜头君一个可以攻击m次，蒜头君的攻击力为h+b
每个蘑菇有血量hp和防御np，如果蒜头君的攻击力大于或等于蘑菇的防御力，
那么就可以消灭蘑菇，需要耗费蘑菇对应的hp次攻击
问，最多可以消灭多少蘑菇？
	输入：
5 10 50 50
120 1
110 2
100 4
80  7
90  6
	输出：
2

*    
* 项目名称：OJ   
* 类名称：jsk_greedy_03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月24日 上午11:18:56   
* @version        
*/
public class jsk_greedy_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//蘑菇数量
		int m = sc.nextInt();
		int hpSum = sc.nextInt();
		hpSum += sc.nextInt(); 
		node[] nds = new node[n];
		for(int i = 0; i < n; i++){
			int hp = sc.nextInt();
			int np = sc.nextInt();
			nds[i] = new node(hp,np);
		}
		//以蘑菇的血量为排序的基准，优先选择血少的
		Arrays.sort(nds, new nodeComparator());
		
		int ans = 0;
		for(int i = 0; i < n; i++){
			if(m == 0){
				break;
			}
			if(nds[i].hp > hpSum){
				continue;
			}else{
				if(m >= nds[i].np){
					m -= nds[i].np;
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static class node{
		public int hp;
		public int np;
		public node(int hp, int np){
			this.hp = hp;
			this.np = np;
		}
	}
	
	//比较器
	private static class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.np - o2.np;
		}


	}

}
