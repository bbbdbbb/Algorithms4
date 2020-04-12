package practice.jsk05;

import java.util.Scanner;

/**   终极优化，实验证明  String类的substring方法十分浪费时间
 * 
 * 	一个数组记录输入的文本，一个变量记录光标的位置，一个变量记录当前大小写的状态
*    
* 项目名称：OJ   
* 类名称：t06   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月11日 下午9:38:21   
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
