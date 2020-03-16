package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] dx = new int[]{1,0,-1,0};
	static int[] dy = new int[]{0,-1,0,1};
	static int dir = 0;//��¼��ǰ����0��ʾx����1��ʾy����2��ʾx����3��ʾy��
	
	public static void main(String[] args) {
		
		int x=0,y=0;

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
        	String opt = scan.next();
        	int len = scan.nextInt();
        	
        	if("back".equals(opt)){
        		dir = (dir + 2) % 4; 
        	}else if("left".equals(opt)){
        		dir = (dir + 3) % 4; 
        	}
        	else if("right".equals(opt)){
        		dir = (dir + 1) % 4; 
        	}
        	
       		x = x + dx[dir] * len;
    		y = y + dy[dir] * len;
        }
        
        System.out.println(x+" "+y);

		scan.close();
	
	}

}


