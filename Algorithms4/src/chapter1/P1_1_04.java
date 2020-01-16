package chapter1;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_1_04   
* 类描述： 第一章，习题1.1.04,指出下列语句的错误       
* 创建人：bbbdbbb   
* 创建时间：2020年1月16日 下午11:38:38   
* @version        
*/
public class P1_1_04 {

	public static void main(String[] args) {
		int a = 0,b = 0,c = 0;
		
		//a. if(a>b) then c = 0;	没有then这个关键字
		//if(a>b) then c = 0;//then cannot be resolved to a variable
		
		//b. if a>b { c = 0;}	缺少括号
		//if a>b { c = 0;}//Syntax error on token "if", ( expected after this token
						//Syntax error, insert ") Statement" to complete IfStatement
		
		//c. if(a>b)	c=0;	正确
		if(a>b)	c=0;
		
		//d.if(a>b) c=0	else b=0;	缺少分号
		//if(a>b) c=0	else b=0;//Syntax error, insert ";" to complete Statement
	}

}
