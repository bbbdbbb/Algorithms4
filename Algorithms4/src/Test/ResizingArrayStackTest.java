package Test;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


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
