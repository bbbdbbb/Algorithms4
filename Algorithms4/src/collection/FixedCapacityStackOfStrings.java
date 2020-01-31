package collection;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�FixedCapacityStackOfStrings   
* �����������ݷ���ջ   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��31�� ����8:39:08   
* @version        
*/
public class FixedCapacityStackOfStrings<Item> {
	private Item[] a;
	private int N;
	
	public FixedCapacityStackOfStrings(int cap){
		a = (Item[]) new Object[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		a[N++] = item;
	}
	public Item pop(){
		return a[--N];
	}
	public boolean isFull(){
		return N==a.length;
	}
}
