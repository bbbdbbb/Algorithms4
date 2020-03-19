package basis.string;

import java.util.Scanner;

/** 字符串变换		字母大小写之间的转换，判断字母是否连续的小技巧，4和5值得复习
 * 	http://lx.lanqiao.cn/problem.page?gpid=T379
 *  算法训练 字符串变换
*    
* 项目名称：OJ   
* 类名称：ALGO_143   
* 创建人：bbbdbbb   
* 创建时间：2020年3月19日 上午10:46:37   
* @version    
* 
* 算法训练 字符串变换    
*     
* 问题描述
　　相信经过这个学期的编程训练，大家对于字符串的操作已经掌握的相当熟练了。今天，徐老师想测试一下大家对于字符串操作的掌握情况。
       徐老师自己定义了1,2,3,4,5这5个参数分别指代不同的5种字符串操作，你需要根据传入的参数，按照徐老师的规定，对输入字符串进行格式转化。
　　徐老师指定的操作如下：
　　1 表示全部转化为大写字母输出，如abC 变成 ABC
　　2 表示全部转换为小写字母输出，如abC变成abc
　　3 表示将字符串整个逆序输出，如 abc 变成 cba
　　4 表示将字符串中对应的大写字母转换为小写字母，而将其中的小写字母转化为大写字母输出，如 abC变成ABc
　　5表示将全部转换为小写字母，并将其中所有的连续子串转换为对应的缩写形式输出，比如abcD 转换为a-d，其次，-至少代表1个字母，既如果是ab，则不需要转换为缩写形式。    


样例输入
	5 ABcdEE
样例输出
	a-ee
*/
public class ALGO_143 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String str = scan.next();
		
		if(n == 1){
			//全部转化为大写字母输出，如abC 变成 ABC
			System.out.println(str.toUpperCase());
		}else if(n == 2){
			//全部转换为小写字母输出，如abC变成abc
			System.out.println(str.toLowerCase());
		}else if(n == 3){
			//将字符串整个逆序输出，如 abc 变成 cba
			StringBuffer sb = new StringBuffer(str);
			System.out.println(sb.reverse());
		}else if(n == 4){
			//将字符串中对应的大写字母转换为小写字母，而将其中的小写字母转化为大写字母输出，如 abC变成ABc
			char[] chs = str.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				if(chs[i] >= 'a' && chs[i] <= 'z'){
					chs[i] -= 32;
					System.out.print(chs[i]);
				}else{
					chs[i] += 32;
					System.out.print(chs[i]);
				}
			}
			
			
		}else{//n = 5
			//将全部转换为小写字母，并将其中所有的连续子串转换为对应的缩写形式输出，比如abcD 转换为a-d，其次，-至少代表1个字母，既如果是ab，则不需要转换为缩写形式。
			str = str.toLowerCase();
			
			int count = 1;//用于计数每一段相连的子字符串的长度
			int len = str.length();
			char[] chs = new char[len + 1];
			for(int i = 0; i < len; i++){
				chs[i] = str.charAt(i);
			}
			//在原字符串的末尾添加字符'a'，不影响连续字符的判断，但可以简化对末尾相连字符的处理
			//列如：  "abcdxxabc"  其中的"abc"在字符串的最后，是不好处理的，所以将其变成"abcdxxabca"
			chs[len] = 'a';
			
			//输出的时候必须把chs[len]包含在内
			for(int i = 1; i <= len; i++){
				if(chs[i] == chs[i-1] + 1){
					//chs[i]与chs[i-1]相连
					count++;
				}else{
					if(count > 2){//相连的字符超过了3个，要将中间的省略
						for(int j = i - count + 1; j <= i - 2; j++){
							chs[j] = '-';
						}
					}
					
					count = 1;
				}
			}
			
			//输出的时候不能把chs[len]包含在内
			for(int i = 0; i < len; i++){
				if(chs[i] == '-' && chs[i+1] != '-'){
					System.out.print(chs[i]);
				}else if(chs[i] != '-'){
					System.out.print(chs[i]);
				}
			}
		}
	}

}
