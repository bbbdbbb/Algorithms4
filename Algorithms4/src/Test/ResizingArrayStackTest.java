package Test;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**   
*    
* 项目名称：Algorithms4   
* 类名称：ResizingArrayStackTest   
* 类描述：collection.ResizingArrayStack下压栈（数组实现）   
* 创建人：bbbdbbb   
* 创建时间：2020年1月30日 下午10:05:05   
* @version        
*/
public class ResizingArrayStackTest {

	public static void main(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty()){
				StdOut.print(s.pop()+"  ");
			}
			
		}
		StdOut.println("\n剩下的元素数量："+s.size());
	}

}
