package Stack;

/**   
*    
* 项目名称：OJ   
* 类名称：Vijos1926   
* 类描述： vijos P1926 紫色的手链  
* https://vijos.org/p/1926
* 题目描述:
* 	那是木姑娘十七岁时，我送给她的生日礼物。（后来手链也成为了我最喜欢的出题媒介）
	记得最初买的手链，由n段紫色的珠子构成，每一颗珠子都被赋予了一种价值评价w[i]。
	为了木姑娘，我只惋惜自己不能摘下漫天繁星送给她。
	不过我并没有将整个手链都送出去，木姑娘的手腕是纤细的。我只需要截取一个子段就可以了，长度无论多少都可以。
	不过我希望，这个子段的最大值异或次大值可以最大，这样或许木姑娘会更喜欢吧。（这里次大是说严格次大）
*样例1
*样例输入1
	5
	5 2 1 4 3
*样例输出1
	7
	
*样例2
*样例输入2
	5
	9 8 3 5 7
*样例输出2
	15
* 
* 创建人：bbbdbbb   
* 创建时间：2020年2月11日 下午5:02:17   
* @version        
*/
public class Vijos1926 {
//	import java.util.Scanner;
//	import java.util.Stack;
//
//	public class Main {
//		public static int update(int ans,int a,int b){
//			if(ans<(a^b))		return a^b;
//			else				return ans;
//		}
//
//		public static void main(String[] args) {
//			Stack<Integer> stack = new Stack<Integer>();
//			int ans = 0;
//
//			Scanner scan = new Scanner(System.in);
//			int N = scan.nextInt();
//			int a[] = new int[N];
//			
//			for(int i=0;i<N;i++){
//				int t = scan.nextInt();
//				while(!stack.isEmpty() && stack.peek()<t){
//					ans = update(ans,stack.peek(),t);
//					stack.pop();
//				}
//				if(!stack.isEmpty())
//					ans = update(ans,stack.peek(),t);
//				stack.push(t);
//			}
//			
//			System.out.println(ans);
//		}
//
//	}

}
