package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�Stack   
* �����������㷨4��P94���㷨1.2 ��ѹ��ջ������ʵ�֣�   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��30�� ����10:54:28   
* @version        
*/
public class Stack<Item> implements Iterable<Item>{
	//�������Ƕ����
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;//ջ��
	private int N;//Ԫ������
	
	public boolean isEmpty(){
		return first==null;//���� N==0
	}
	public int size(){
		return N;
	}
	public void push(Item item){//��ջ�����Ԫ��
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	public Item pop(){//��ջ��ɾ��Ԫ��
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    public static Stack<String> copy(Stack<String> stack){
    	//����ջʱ��Ҫע��ջ�е�Ԫ��˳��
    	Stack<String> temp = new Stack<>();
    	Stack<String> copyStack = new Stack<>();
    	for(String s : stack){
    		temp.push(s);
    	}
    	for(String t : temp){
    		copyStack.push(t);
    	}
    	return copyStack;
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
