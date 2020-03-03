package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static char[][] chs;
	private static int n;
	private static int m;
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		chs = new char[n][m]; 
		int count = 0;

		for(int i=0;i<n;i++){
			String input = scan.next();
			for(int j=0;j<m;j++){
				chs[i][j] = input.charAt(j);
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(chs[i][j]=='W'){
					dfs(i,j);
					count++;
				}
				
			}
			
		}
		System.out.println(count);
		
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	
	private static void dfs(int x,int y) {
		
		chs[x][y] = '.';
		
		for(int dx=-1;dx<=1;dx++){
			for(int dy=-1;dy<=1;dy++){
				int newX = x + dx;
				int newY = y + dy;
				
				if(newX>=0 && newX<n && newY>=0 && newY<m && chs[newX][newY]=='W')		dfs(newX,newY);
			}
		}
	}

	
}
