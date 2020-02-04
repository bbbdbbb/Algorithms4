package chapter1;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_04_Parenthses   
* ����������ϰ1.3.04,��дһ��Stack����Parenthses��
* 			ʹ��ջ�ж������Ƿ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��1�� ����4:46:49   
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
			}else{//��׼�����к��������ַ�
				System.out.println(false);
				System.exit(0);
			}
			
		}
		//����ִ�е����˵��ȫ�������������  
		System.out.println(true);
	}

}
