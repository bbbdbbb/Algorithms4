package chapter1;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_1_06   
* ����������һ�£�ϰ��1.1.06,������γ�����ӡ��ʲô��  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��18�� ����8:48:51   
* @version        
*/
public class P1_1_06 {

	public static void main(String[] args) {
		int f=0;
		int g=1;
		System.out.println("f="+f+"  g="+g);
		for(int i=0;i<=15;i++){
			//System.out.println(f);
			f=f+g;
			g=f-g;
			System.out.println("f="+f+"  g="+g);
		}
	}

}
