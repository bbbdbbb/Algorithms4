package sort;

import java.util.Scanner;

/**   
*    
* 项目名称：OJ   
* 类名称：ALGO_217   
* 类描述：排序	<归并排序>
* 		蓝桥杯算法提升 217 景点游览
* 样例(1)
*样例输入(1)
	4
	3 2 4 1
*样例输出(1)
	4 3 2 1  
* 创建人：bbbdbbb   
* 创建时间：2020年2月25日 下午9:30:11   
* @version        
*/
public class ALGO_217 {

	private static int[] aux = null;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		aux = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = scan.nextInt();
		}

		//使用归并排序
		sort(arr,0,N-1);
		
		for(int i=N-1;i>=0;i--){
			System.out.print(arr[i]+" ");
		}
	}

	private static void sort(int[] arr, int lo, int hi) {
		
		if(hi<=lo){
			return;
		}
		int mid = lo+(hi-lo)/2;
		sort(arr,lo,mid);
		sort(arr,mid+1,hi);

		merge(arr,lo,mid,hi);
	}

	private static void merge(int[] arr, int lo, int mid, int hi) {
		int i=lo;
		int j=mid+1;
		
		for(int k=lo;k<=hi;k++){
			aux[k] = arr[k];
		}
		
		for(int k=lo;k<=hi;k++){
			if(i>mid)		arr[k] = aux[j++];
			else if(j>hi)	arr[k] = aux[i++];
			else if(aux[j]<aux[i])	arr[k] = aux[j++];
			else			arr[k] = aux[i++];
		}
	}

}
