package chapter1;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_04_Parenthses   
* 类描述：练习1.3.04,编写一个Stack用例Parenthses，
* 			使用栈判断括号是否配对完整   
* 创建人：bbbdbbb   
* 创建时间：2020年2月1日 下午4:46:49   
* @version        
*/
public class P1_3_04_Parenthses {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(item.equals("(") || item.equals("[") || item.equals("{")){
				s.push(item);
			}else if(!s.isEmpty() && item.equals(")")){
				if(s.isEmpty()){
					System.out.println(false);
					System.exit(0);
				}
				String str = s.pop();
				if(!"(".equals(str)){
					System.out.println(false);
					System.exit(0);
				}
			}else if(!s.isEmpty() && item.equals("]")){
				String str = s.pop();
				if(!"".equals(str)){
					System.out.println(false);
					System.exit(0);
				}
			}else if(!s.isEmpty() && item.equals("}")){
				String str = s.pop();
				if(!"{".equals(str)){
					System.out.println(false);
					System.exit(0);
				}
			}else{//标准输入中含有其他字符
				System.out.println(false);
				System.exit(0);
			}
			
		}
		//程序执行到这里，说明全部括号配对完整  
		System.out.println(true);
	}

}
