package chapter1;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_08   
* ����������ϰ1.3.08�������������룬����DoublingStackOfStrings����������ݺʹ�С��   
* 		it was - the best - of times - - - it was - the - -
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��3�� ����4:38:58   
* @version        
*/
public class P1_3_08 {
	//���ϲ�û�п���DoublingStackOfStrings��ʵ�ִ��룬������Ӣ�����ƿ��Կ�����
	//	����һ��ջ��ʵ���࣬ջ�������ɱ������Ӻͼ��٣��ⲻ����P88�㷨1.1ResizingArrayStack�
	public static void main(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-")){
				s.push(item);
				StdOut.println("\n\n���룺"+item);
				StdOut.println("ջ�ĳ���"+s.size());
				StdOut.print("ջ�е����ݣ�");
				for(String str : s){
					StdOut.print(str+"  ");
				}
			}
			else if(!s.isEmpty()){			
				s.pop();
				StdOut.println("\n\n���룺"+item);
				StdOut.println("ջ�ĳ���"+s.size());
				StdOut.print("ջ�е����ݣ�");
				for(String str : s){
					System.out.print(str+"  ");
				}
			}
			
		}
		StdOut.println("\n\n���ʣ�µ�Ԫ��������"+s.size());
	}

}
