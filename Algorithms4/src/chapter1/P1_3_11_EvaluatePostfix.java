package chapter1;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_11_EvaluatePostfix   
* �������� ��ϰ1.3.11,�ӱ�׼����õ�һ��������ʽ����ֵ����ӡ�����
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��5�� ����9:30:19   
* @version        
*/
public class P1_3_11_EvaluatePostfix {

	public static void main(String[] args) {
		Stack<String> number = new Stack<>();

		System.out.println("���룺");
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			System.out.print(item+"  ");
			
			if(Character.isDigit(item.charAt(0))){//item������
				number.push(item);
			}else if("+".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first+second+"");
			}else if("-".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first-second+"");
			}else if("*".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first*second+"");
			}else if("/".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first/second+"");
			}else{
				System.out.println("\n����ĺ�����ʽ����ȷ������");
			}			
		}
		
		if(!number.isEmpty())
			System.out.println("\n�����\n"+number.pop());
	}
}
