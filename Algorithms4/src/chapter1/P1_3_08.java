package chapter1;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_08   
* 类描述：练习1.3.08，给定以下输入，给出DoublingStackOfStrings的数组的内容和大小。   
* 		it was - the best - of times - - - it was - the - -
* 创建人：bbbdbbb   
* 创建时间：2020年2月3日 下午4:38:58   
* @version        
*/
public class P1_3_08 {
	//书上并没有看到DoublingStackOfStrings的实现代码，但根据英文名称可以看出：
	//	这是一个栈的实现类，栈的容量成倍的增加和减少，这不就是P88算法1.1ResizingArrayStack嘛？
	public static void main(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-")){
				s.push(item);
				StdOut.println("\n\n输入："+item);
				StdOut.println("栈的长度"+s.size());
				StdOut.print("栈中的内容：");
				for(String str : s){
					StdOut.print(str+"  ");
				}
			}
			else if(!s.isEmpty()){			
				s.pop();
				StdOut.println("\n\n输入："+item);
				StdOut.println("栈的长度"+s.size());
				StdOut.print("栈中的内容：");
				for(String str : s){
					System.out.print(str+"  ");
				}
			}
			
		}
		StdOut.println("\n\n最后剩下的元素数量："+s.size());
	}

}
