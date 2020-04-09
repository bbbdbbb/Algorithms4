package search.dfs;

import java.util.Scanner;

/** 计蒜客学习中心   dfs剪枝
 * 	《因数最多的数》
 * 	 https://www.jisuanke.com/course/6497/341236
 *
	输入：
3
10
100
1000

	输出：
6
60
840  

*	剪枝：
*	1.未剪枝的思路是从数字1到num，分别计算它们因数的个数，用一个变量记录因数最多的值
*	2.剪枝：不从数字1到num依次判断，而是计算从质数1到47的个数
*		  这里最重要的是，要求值小的质因数的个数大于或等于值大的
*		  列如： 2 * 2 * 3  =  12 和 2 * 3 * 3 = 18 
*		 12和18的因数个数都是6，因为12<18,取12.
*		  那么18这个数就是多余计算的，可以剪枝  

* 项目名称：OJ   
* 类名称：jsk_dfs06_cut   
* 创建人：bbbdbbb   
* 创建时间：2020年4月9日 下午10:18:50   
* @version        
*/
public class jsk_dfs06_cut {
	
	private static long[] zys = new long[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	private static int n;
	private static long[] ns;
	
	private static long ans = 0;
	private static int ansCnt = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ns = new long[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextLong();
		}
		for(int i = 0; i < n; i++){
			ans = 0;
			ansCnt = 0;
			dfs(0,60,1,1,i);
			System.out.println(ans);
		}
		
		
	}

	/**
	 * @param index 记录当前应该访问的数组zys[]的下标
	 * @param m		剩余可以选择的质因数的个数(全部选2，最多可以选五十多个)
	 * @param num	当前的选中所有质因数的积
	 * @param cnt	当前数num的因子个数
	 * @param ni	对应数组ns[]的下标
	 */
	private static void dfs(int index, int m, long num, int cnt, int ni) {
		
		if(cnt > ansCnt){
			ansCnt = cnt;
			ans = num;
		}else if(cnt == ansCnt && num < ans){
			ans = num;
		}
		
		//已经计算了15个质因数了，现在索引已经超出数组zys[]的范围
		if(index == 15){
			return;
		}
		
		for(int i = 1; i <= m; i++){
			num = num * zys[index];
			if(num > ns[ni]){
				break;
			}
			dfs(index + 1, i, num, cnt * (i + 1), ni);
		}
	
	}

}
