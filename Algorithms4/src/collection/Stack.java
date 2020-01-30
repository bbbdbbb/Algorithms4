package collection;

import java.util.Iterator;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：Stack   
* 类描述：《算法4》P98的算法1.2 下压堆栈（链表实现）   
* 创建人：bbbdbbb   
* 创建时间：2020年1月30日 下午10:54:28   
* @version        
*/
public class Stack<Item> implements Iterable<Item>{
	//定义结点的嵌套类
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;//栈顶
	private int N;//元素数量
	
	public boolean isEmpty(){
		return first==null;//或者 N==0
	}
	public int size(){
		return N;
	}
	public void push(Item item){//向栈顶添加元素
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	public Item pop(){//从栈顶删除元素
		Item item = first.item;
		first.next = first.next.next;
		N--;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	
}
