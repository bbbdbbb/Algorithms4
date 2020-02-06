package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�ResizingArrayQueue   
* �������� �ɱ䳤����(����ʵ��)  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��6�� ����8:03:25   
* @version        
*/
public class ResizingArrayQueue<Item>  implements Iterable<Item>{
    private Item[] q;       // �������Ԫ�ص�����
    private int n;          // ��¼���еĳ���
    private int first;      // ��¼�����е�һ��Ԫ�ص�����
    private int last;       // ��¼���������һ��Ԫ�ص�����
    
    public ResizingArrayQueue() {
        q = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }
    
    public boolean isEmpty() {
    	//�����������һ������n����¼����ĳ���
    	//�����Ͳ��ý��и��������
        return n == 0;
    }  
    public int size() {
        return n;
    }
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
        	//�������е�Ԫ�����θ��Ƶ�����temp[]��
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = n;
    }
    public void enqueue(Item item) {
        //����q[]������������������еĳ���
        if (n == q.length) resize(2*q.length);   
        q[last++] = item;                        
        if (last == q.length) last = 0;          
        n++;
    }  
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("�����޿ɳ���Ԫ�أ�����");
        Item item = q[first];
        q[first] = null;//Ӧ�ú�ǰ��һ������ֹ��������
        n--;
        first++;
        if (first == q.length) first = 0;
        //����q[]���������࣬�˷���Դ����С���еĳ���
        if (n > 0 && n == q.length/4) resize(q.length/2); 
        return item;
    }
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    
}
