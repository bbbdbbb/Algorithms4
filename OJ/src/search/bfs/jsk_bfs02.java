package search.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**  �����ѧϰ����   �����������bfs 
 * 	һά����
 * 	https://www.jisuanke.com/course/6497/341239
 * 	˼·��
 * 		ͬʱ���ö��к�hashmap��������⡣���о���bfs�Ļ���
 * 		hashmap��key��ĳһʱ�����ӵ�λ�ã�value�Ǵ�ʱ�̵�ǰһʱ�̵�����λ��
 * 		��N = 3ʱ����һ��kv���ǣ�"WWW BBB","s"��
 * 		�ڶ����kv���ǣ�"WW WBBB","WWW BBB"���ͣ�"WWWB BB","WWW BBB"��
 * 
 * 		��󣬵������� "BBB WWW"�ͽ���bfs������Ե���bfs��·����
 * 
 * 	2  ������  "WW BB"  ���ܵĲ������£�
 * 	"W WBB"  "WBW B"  "WBWB "   "WB BW"  " BWBW"  	"B WBW"   "BBW W"  "BB WW"
 * 	
 
	����
4
	���
4 6 7 5 3
2 4 6 8 9
7 5 3 1 2
4 6 8 7 5
3 4 6 5

*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_bfs02  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��10�� ����8:32:54   
* @version        
*/
public class jsk_bfs02 {
	
	private static int[] ans = new int[1000000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, String> hm = new HashMap<>(); 
		LinkedList<String> q = new LinkedList<String>();
		String prev = null;
		
		//��������ĳ�ʼ״̬
		String str = "";
		String end = "";
		for(int i = 0; i < N; i++){
			str += "W" ;
			end += "B";
		}
		str += " ";
		end += " ";
		for(int i = 0; i < N; i++){
			str += "B";
			end += "W";
		}
		
		q.add(str);
		hm.put(str, "s");
		while(!q.isEmpty()){
			String now = q.poll();
			
			//����
			if(now.equals(end)){
				break;
			}
			
			//û�н�����bfs
			char[] chs = now.toCharArray();
			int index = now.indexOf(" ");
			
			
			//�ո������ƶ�
			if(index - 1 >= 0){
				chs = ex(chs,index,index-1);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//û���߹��ⲽ
					hm.put(newStr, now);
					q.add(newStr);
				}
				//�ָ� ����chs
				chs = ex(chs,index,index-1);
			}
			
			//�ո������ƶ�
			if(index + 1 < (2 * N + 1)){
				chs = ex(chs,index,index+1);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//û���߹��ⲽ
					hm.put(newStr, now);
					q.add(newStr);
				}
				//�ָ� ����chs
				chs = ex(chs,index,index+1);
			}
			

			
			//�ո����ұ���
			if(index + 2 < (2 * N + 1) && chs[index + 1] != chs[index + 2]){
				chs = ex(chs,index,index+2);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//û���߹��ⲽ
					hm.put(newStr, now);
					q.add(newStr);
				}
				//�ָ� ����chs
				chs = ex(chs,index,index+2);
			}
			
			//�ո����ұ���
			if(index - 2 >= 0 && chs[index - 1] != chs[index - 2]){
				chs = ex(chs,index,index-2);
				String newStr = String.valueOf(chs);
				if(!hm.containsKey(newStr)){//û���߹��ⲽ
					hm.put(newStr, now);
					q.add(newStr);
				}
				//�ָ� ����chs
				chs = ex(chs,index,index-2);
			}
		}
		
		
//		Iterator iter = hm.entrySet().iterator();
//		while (iter.hasNext()) {
//		  Map.Entry entry = (Map.Entry) iter.next();
//		  Object key = entry.getKey();
//		  Object val = entry.getValue();
//		  System.out.println(key+"    "+val);
//		}
		
		int count = 0;
		while(!end.equals("s")){
			//System.out.println(end);
			ans[count++] = end.indexOf(" ") + 1;
			end = hm.get(end);
		}
		
		int yu5 = 1;
		for(count-=2;count >= 0; count--){
			if(yu5 % 5 != 0){
				System.out.print(ans[count] + " ");
			}else{
				System.out.println(ans[count]);
			}
			yu5++;
		}
		
	}

	
	private static char[] ex(char[] chs, int i, int j) {

		char temp = chs[i];
		chs[i] = chs[j];
		chs[j] = temp;
		
		return chs;
	}

}
