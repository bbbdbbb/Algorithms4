package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：ResizingArrayQueue   
* 类描述： 可变长队列(数组实现)  
* 创建人：bbbdbbb   
* 创建时间：2020年2月6日 下午8:03:25   
* @version        
*/
public class ResizingArrayQueue<Item>  implements Iterable<Item>{
    private Item[] q;       // 储存队列元素的数组
    private int n;          // 记录队列的长度
    private int first;      // 记录队列中第一个元素的索引
    private int last;       // 记录队列中最后一个元素的索引
    
    public ResizingArrayQueue() {
        q = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }
    
    public boolean isEmpty() {
    	//特意多声明了一个变量n来记录数组的长度
    	//这样就不用进行负责的运算
        return n == 0;
    }  
    public int size() {
        return n;
    }
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
        	//将队列中的元素依次复制到数组temp[]中
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = n;
    }
    public void enqueue(Item item) {
        //数组q[]的容量不够，扩大队列的长度
        if (n == q.length) resize(2*q.length);   
        q[last++] = item;                        
        if (last == q.length) last = 0;          
        n++;
    }  
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("队列无可出列元素！！！");
        Item item = q[first];
        q[first] = null;//应该和前面一样，防止对象游离
        n--;
        first++;
        if (first == q.length) first = 0;
        //数组q[]的容量过多，浪费资源，减小队列的长度
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
