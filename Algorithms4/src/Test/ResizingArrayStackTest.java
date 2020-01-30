package Test;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�ResizingArrayStackTest   
* ��������collection.ResizingArrayStack��ѹջ������ʵ�֣�   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��30�� ����10:05:05   
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
		StdOut.println("\nʣ�µ�Ԫ��������"+s.size());
	}

}
