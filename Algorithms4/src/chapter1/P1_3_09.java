package chapter1;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_09   
* �������� ��ϰ1.3.09,��дһ�γ��򣬴ӱ�׼����õ�һ��ȱ�������ŵı��ʽ��
* 		����ӡ�ڳ���ȫ����֮���������ʽ��
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��3�� ����8:26:29   
* @version        
*/
public class P1_3_09 {

	public static void main(String[] args) {
		Stack<String> number = new Stack<>();//�洢��ʽ�е�����
		Stack<String> operator = new Stack<>();//�洢��ʽ�е������

		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			System.out.println(item);
			if(Character.isDigit(item.charAt(0))){//���item������0~9��ѹ��numberջ
				number.push(item);				
			}else if("+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item)){
				//���item���������ѹ��operatorջ
				operator.push(item);
			}else if(")".equals(item) && number.size()>=2 && operator.size()>=1){//���item��')'
				String second = number.pop();
				String first = number.pop();
				String newBracket = "("+first+operator.pop()+second+")";
				number.push(newBracket);
				
				System.out.println("��׮�� 1�²��������ű��ʽΪ "+newBracket);
				
			}else{
				//�������ݲ��ܹ���һ�����������ű��ʽ
				System.out.println("���ݴ��󣡣���");
			}
			
		}
		if(number.size()==1){
			System.out.print("�����"+number.pop());
		}

	}

}
