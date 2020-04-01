package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	private static char[][] map = new char[9][9];
	private static boolean flag = false;
	private static boolean row[][] = new boolean[9][10];
	private static boolean col[][] = new boolean[9][10];
	private static boolean rea[][] = new boolean[9][10];


	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				map[i][j] = scan.next().charAt(0);
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j] >= '1' && map[i][j] <= '9'){
					row[i][map[i][j] - '0'] = true;
					col[j][map[i][j] - '0'] = true;
					rea[i/3*3 + j/3][map[i][j] - '0'] = true;
				}
			}
		}
		

		dfs(0,0);
		
		
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	
	
	private static void dfs(int x, int y) {

		//System.out.println("x = " + x + " y = " + y);
		if(flag){
			return;
		}
		if(x == 9){
			flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(j != 8){
						System.out.print(map[i][j]+" ");
					}else{
						System.out.println(map[i][j]);
					}
				}
			}
			return;
		}
		
		
		if(y == 9){
			dfs(x + 1, 0);
			return;
		}
		
		if(map[x][y] != '*'){
			dfs(x,y+1);
			return;
		}
		
		for(int i = 1; i <= 9; i++){
//			System.out.println(""+row[x][i] + col[y][i] + rea[x/3*3 + y/3][i]);
//			System.out.println((!row[x][i]) && (!col[y][i]) && (rea[x/3*3 + y/3][i]));
			if(!row[x][i] && !col[y][i] && !rea[x/3*3 + y/3][i]){
				map[x][y] = (char) ('0' + i);
				row[x][i] = true;
				col[y][i] = true;
				rea[x/3*3 + y/3][i] = true;
				
				//System.out.println(x + " " + y +" " + i);
				dfs(x,y+1);
				map[x][y] = '*';
				row[x][i] = false;
				col[y][i] = false;
				rea[x/3*3 + y/3][i] = false;
			}
		}
		
	}



	
	
}