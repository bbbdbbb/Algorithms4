package practice.wbwp02;

/**     
* ��������   ���ű�������2 ��Ŀ��  �������        
*/
public class p03 {

	public static void main(String[] args) {
		
		int count = 0;
		
		//�����һ�����ж��ٸ������ķ���
		for(int x = 1; x <= 1000; x++){
			for(int y = 1; y <= 1000; y++){
				//�жϵ�һ���޵�ÿһ����������Ͻǵ�Բ�ĵľ����ǲ���С�ڰ뾶
				if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)) <= 1000){
					count++;
				}
			}
		}
		
		//��һ���޵ķ���������4
		System.out.println(4*count);
	}

}
