package practice.jsk05;

import java.util.Scanner;

/**   �ռ��Ż���ʵ��֤��  String���substring����ʮ���˷�ʱ��
 * 
 * 	һ�������¼������ı���һ��������¼����λ�ã�һ��������¼��ǰ��Сд��״̬
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�t06   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��11�� ����9:38:21   
* @version        
*/
public class t06 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        char[] ans = new char[m];
        int index = 0;
        boolean flag = true;
        for(int i = 0; i < m; i++,index++){
            String str = sc.next();
            if(str.length() == 1){
                if(flag){
                	ans[index] = str.charAt(0);
                }else{
                	ans[index] = str.toUpperCase().charAt(0);
                }
            }else if("CapsLock".equals(str)){
                flag = !flag;
                index--;
            }else if("Backspace".equals(str)){
                if(index > 0){
                	index -= 2;
                }
            }else if("Space".equals(str)){
            	ans[index] = ' ';
            }
        }
        for(int i = 0; i < index; i++){
        	System.out.print(ans[i]);
        }
        
    }
}
