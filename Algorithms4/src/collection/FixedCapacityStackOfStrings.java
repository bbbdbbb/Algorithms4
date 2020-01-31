package collection;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：FixedCapacityStackOfStrings   
* 类描述：定容泛型栈   
* 创建人：bbbdbbb   
* 创建时间：2020年1月31日 下午8:39:08   
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
