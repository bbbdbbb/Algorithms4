package chapter1;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_1_04   
* �������� ��һ�£�ϰ��1.1.04,ָ���������Ĵ���       
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��16�� ����11:38:38   
* @version        
*/
public class P1_1_04 {

	public static void main(String[] args) {
		int a = 0,b = 0,c = 0;
		
		//a. if(a>b) then c = 0;	û��then����ؼ���
		//if(a>b) then c = 0;//then cannot be resolved to a variable
		
		//b. if a>b { c = 0;}	ȱ������
		//if a>b { c = 0;}//Syntax error on token "if", ( expected after this token
						//Syntax error, insert ") Statement" to complete IfStatement
		
		//c. if(a>b)	c=0;	��ȷ
		if(a>b)	c=0;
		
		//d.if(a>b) c=0	else b=0;	ȱ�ٷֺ�
		//if(a>b) c=0	else b=0;//Syntax error, insert ";" to complete Statement
	}

}
