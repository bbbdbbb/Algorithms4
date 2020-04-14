package dp.unknow;

import java.util.Scanner;

/**	计蒜客学习中心 初始动态规划   
 * 	逃生  ——> 最佳路线
 * 	https://www.jisuanke.com/course/6497/341107
*    
* 项目名称：OJ   
* 类名称：jsk_dp05   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月14日 下午4:04:20   
* @version        
*/
public class jsk_dp05 {

	private static int[][] map;
	private static int[][] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n+10][m+10];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int v = sc.nextInt();
		int c = sc.nextInt();
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		f = new int[n+10][m+10];
		f[x][y] = v;
		
		//左上
		for(int i = x; i >= 1; i--){
			for(int j = y; j >= 1; j--){
				if(i == x && j == y){//遍历到起点，直接跳过
					continue;
				}else if(i == x){//对 起点所在行的点进行初始化
					f[i][j] = f[i][j + 1] + map[i][j];
				}else if(j == y){//每到新的一行，就对 和起点在同一列的点进行初始化
					f[i][j] = f[i + 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j + 1], f[i + 1][j]) + map[i][j];
				}
				
//				if(f[i][j] <= 0){//死掉一次，就把它的值设置为非常小，让它不能复活
//					f[i][j] = Integer.MIN_VALUE;
//				}
				//直接赋值为无限性也不行，如果下一个点是也是负数，两个负数相加会导致 数字溢出，变成一个负数了
				//所有应该考虑一个合适的负数作为 死亡的象征
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		//右上
		for(int i = x; i >= 1; i--){
			for(int j = y; j <= m; j++){
				if(i == x && j == y){//遍历到起点，直接跳过
					continue;
				}else if(i == x){//对 起点所在行的点进行初始化
					f[i][j] = f[i][j - 1] + map[i][j];
				}else if(j == y){//每到新的一行，就对 和起点在同一列的点进行初始化
					f[i][j] = f[i + 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]) + map[i][j];
				}
				
				
//				if(f[i][j] <= 0){//死掉一次，就把它的值设置为非常小，让它不能复活
//					f[i][j] = Integer.MIN_VALUE;
//				}
				//直接赋值为无限性也不行，如果下一个点是也是负数，两个负数相加会导致 数字溢出，变成一个负数了
				//所有应该考虑一个合适的负数作为 死亡的象征
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		//左下
		for(int i = x; i <= n; i++){
			for(int j = y; j >= 1; j--){
				if(i == x && j == y){//遍历到起点，直接跳过
					continue;
				}else if(i == x){//对 起点所在行的点进行初始化
					f[i][j] = f[i][j + 1] + map[i][j];
				}else if(j == y){//每到新的一行，就对 和起点在同一列的点进行初始化
					f[i][j] = f[i - 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j + 1], f[i - 1][j]) + map[i][j];
				}
				
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		//右下
		for(int i = x; i <= n; i++){
			for(int j = y; j <= m; j++){
				if(i == x && j == y){//遍历到起点，直接跳过
					continue;
				}else if(i == x){//对 起点所在行的点进行初始化
					f[i][j] = f[i][j - 1] + map[i][j];
				}else if(j == y){//每到新的一行，就对 和起点在同一列的点进行初始化
					f[i][j] = f[i - 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) + map[i][j];
				}
				
//				if(f[i][j] <= 0){//死掉一次，就把它的值设置为非常小，让它不能复活
//					f[i][j] = Integer.MIN_VALUE;
//				}
				//直接赋值为无限性也不行，如果下一个点是也是负数，两个负数相加会导致 数字溢出，变成一个负数了
				//所有应该考虑一个合适的负数作为 死亡的象征
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		
		int max = Math.max(Math.max(f[1][1], f[1][m]), Math.max(f[n][1], f[n][m]));
		if(max <= 0){
			System.out.println(-1);
		}else{
			System.out.println(max);
		}
		
	}

}
