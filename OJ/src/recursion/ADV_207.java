package recursion;

import java.util.Scanner;

/**
 * 算法提高 最长字符序列
 * http://lx.lanqiao.cn/problem.page?gpid=T378   
*    
* 项目名称：OJ   
* 类名称：ADV_207   
* 类描述：经典的 递归问题，第一次不会，值得OJ   
* 
	设x(i), y(i), z(i)表示单个字符，则X={x(1)x(2)……x(m)}，Y={y(1)y(2)……y(n)}，Z={z(1)z(2)……z(k)},
    我们称其为字符序列，其中m,n和k分别是字符序列X，Y，Z的长度，括号()中的数字被称作字符序列的下标。
　	如果存在一个严格递增而且长度大于0的下标序列{i1,i2……ik}，使得对所有的j=1,2,……k，有x(ij)=z(j)，那么我们称Z是X的字符子序列。
    而且，如果Z既是X的字符子序列又是Y的字符子序列，那么我们称Z为X和Y的公共字符序列。
　	在我们今天的问题中，我们希望计算两个给定字符序列X和Y的最大长度的公共字符序列，这里我们只要求输出这个最大长度公共子序列对应的长度值。
　	举例来说，字符序列X=abcd，Y=acde，那么它们的最大长度为3，相应的公共字符序列为acd。

* 创建人：bbbdbbb   
* 创建时间：2020年2月28日 下午9:34:48   
* @version        
*/
public class ADV_207 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		
		int end = f(chs1,0,chs2,0);		
		System.out.print(end);

	}

	private static int f(char[] chs1, int i, char[] chs2, int j) {
		
		//递归终止条件
		if(i==chs1.length || j==chs2.length)	return 0;
		else if(chs1[i] == chs2[j])				return f(chs1,i+1,chs2,j+1)+1;
		else									return Math.max(f(chs1,i+1,chs2,j), f(chs1,i,chs2,j+1));

	}
}
