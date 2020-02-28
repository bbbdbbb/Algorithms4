package sort;

import java.util.Scanner;

/**   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_217   
* ������������	<�鲢����>
* 		���ű��㷨���� 217 ��������
* ����(1)
*��������(1)
	4
	3 2 4 1
*�������(1)
	4 3 2 1  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��25�� ����9:30:11   
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

		//ʹ�ù鲢����
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
