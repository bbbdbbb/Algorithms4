package chapter1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 
 * 项目名称：Algorithms4 
 * 类名称：P1_3_03 
 * 类描述：练习1.3.03,判断出栈顺序是否正确 入栈操作会将整数0到9按顺序压入栈；
 * 		     出栈操作会打印出返回值。 下面哪种序列是不可能产生的？ 
 * 创建人：bbbdbbb 
 * 创建时间：2020年1月31日 下午9:16:15
 * 
 * @version
 */
public class P1_3_03 {
	/**
	 * 这到题可以直接判断，但是想到我要参加蓝桥杯比赛（我是一个新手）， 就打算使用代码来判断整数的出栈顺序是否正确
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int N = 8;// 输入:行数
		// 建立一个整数栈的数组
		Queue<Integer>[] a = (Queue<Integer>[]) new Queue[N];
		int i = 0;
		for(int j=0;j<N;j++){
			a[j] = new Queue<Integer>();
		}

		//获取数据
		for (;i<N; i++) {
			for(int j=0;j<10;j++){
				if (!StdIn.isEmpty()) {
					int item = StdIn.readInt();
					
					a[i].enqueue(item);
				}else{
					System.out.println("输入数据错误！！！");
					System.exit(0);
				}	
			}					
		}
		
		//判断
		for(int j=0;j<N;j++){
			//先打印 题目中整数的出栈序列
			for(int num : a[j]){
				System.out.print(num+"  ");
			}

			boolean bigFlag = true;		
			//判断
			while(!a[j].isEmpty()){
				Queue<Integer> temp = new Queue<Integer>();
				int number = a[j].dequeue();//从栈中拿出来一个数number
				for(int num : a[j]){//把栈中所有比number小的数压入（复制）到temp栈中
					if(number > num){
						temp.enqueue(num);
					}
				}
				//判断比number小的数是否逆序
				boolean flag = true;
				while(!temp.isEmpty()){
					int t = temp.dequeue();
					if(number<t){
						flag = false;
						break;
					}
					number = t;
				}
				if(flag==false){
					bigFlag = false;
					System.out.println(bigFlag);
					break;
				}
			}
			
			if(bigFlag==true){
				System.out.println(bigFlag);
			}
		}

	}
}
