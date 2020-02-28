package recursion;

import java.util.Scanner;

/**
 * 算法训练 幂方分解
 * http://lx.lanqiao.cn/problem.page?gpid=T72   
*    
* 项目名称：OJ   
* 类名称：ALGO_12   
* 题目描述：  递归，设置终止条件
* 		　
*  任何一个正整数都可以用2的幂次方表示。例如：
　　137=27+23+20 
　　同时约定方次用括号来表示，即ab 可表示为a（b）。
　　由此可知，137可表示为：
　　2（7）+2（3）+2（0）
　　进一步：7= 22+2+20 （21用2表示）
　　3=2+20 
　　所以最后137可表示为：
　　2（2（2）+2+2（0））+2（2+2（0））+2（0）
　　又如：
　　1315=210 +28 +25 +2+1
　　所以1315最后可表示为：
　　2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）

*   
* 创建人：bbbdbbb   
* 创建时间：2020年2月28日 下午4:54:19   
* @version        
*/
public class ALGO_12 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		if(n==0){
			System.out.print(0);
		}else{
			String str = f(n);
			System.out.print(str);
		}


	}

	private static String f(int n) {
		
		String temp = "";
			
		//将整数转化为二进制
		String binaryN = Integer.toBinaryString(n);
		int N = binaryN.length();
		System.out.println("bN:"+binaryN);
		for(int i=0;i<N;i++){
			if(binaryN.charAt(i)=='1' && i==N-1){
				temp = temp + "2(0)";
			}else if(binaryN.charAt(i)=='1' && i==N-2){
				temp = temp + "2";
			}else if(binaryN.charAt(i)=='1' && i==N-3){
				temp = temp + "2(2)";
			}else if(binaryN.charAt(i)=='1'){
				temp = temp + "2(" + f(binaryN.length()-i-1) + ")";
			}
			
			
			if(i!=N-1 && binaryN.charAt(i)=='1' && binaryN.lastIndexOf('1')>i)	temp = temp + "+";
		}
		return temp;
	}
	
	//精简版 代码
	private static String f2(int n) {
		
		String temp = "";
		
		//将整数转化为二进制
		String binaryN = Integer.toBinaryString(n);
		int N = binaryN.length();
		System.out.println("bN:"+binaryN);
		
		for(int i=0;i<N;i++){//遍历数字N的二进制binaryN的每一位
			if(binaryN.charAt(i)=='0'){//跳过binaryN中为零的部分
				continue;
			}
			
			//前面三个if是递归的终止条件
			if(i==N-1){//2^0
				temp = temp + "2(0)";
			}else if( i==N-2){//2^1
				temp = temp + "2";
			}else if(i==N-3){//2^2
				temp = temp + "2(2)";
			}else if(binaryN.charAt(i)=='1'){//2的多次方，这里需要递归求多次方的字符表达式
				temp = temp + "2(" + f(binaryN.length()-i-1) + ")";
			}
			
			// binaryN.lastIndexOf('1')>i 这个是判断是否需要  加上加号
			if(binaryN.lastIndexOf('1')>i)	temp = temp + "+";
		}
		return temp;
	}



}
