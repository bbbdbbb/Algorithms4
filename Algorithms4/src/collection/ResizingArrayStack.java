package collection;

import java.util.Iterator;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：ResizingArrayStack   
* 类描述：《算法4》P88的算法1.1 下压栈（数组实现）   
* 创建人：bbbdbbb   
* 创建时间：2020年1月30日 下午10:06:17   
* @version        
*/
public class ResizingArrayStack<Item> implements Iterable<Item>{
	//Java中不能直接创建泛型数组
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];//栈元素
	private int N = 0;//元素数量
	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	@SuppressWarnings("unchecked")
	public void resize(int max){//将栈中的所有元素移动到一个大小为max的新数组
		Item[] temp = (Item[])new Object[max];
		for(int i=0;i<N;i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	public void push(Item item){//将元素添加到栈顶
		if(N==a.length)	resize(2*N);
		a[N++] = item;
	}
	public Item pop(){//从栈顶删除元素
		Item item = a[--N];
		a[N] = null;//避免对象游离
		if(N>0 && N==(a.length/4))	resize(a.length/2);
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}


	
	
}
