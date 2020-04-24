package greedy;

import java.util.Scanner;
import java.util.Arrays;

/** 计蒜客学习中心	贪心算法
 * 	节约用电
 *  https://www.jisuanke.com/course/6497/341061
 *  
	题目：
横着有一行n盏电灯，每盏电灯的位置是a[i]，如果某盏灯的左右最近两盏亮着的灯的距离不超过m
就可以把这盏灯关闭。其中第一盏灯和最后一盏灯不能关点
	输入: 电灯的盏数n和最大距离m  电灯的位置a[i]
4 5
3 6 10 1
	输出：
1

*    
* 项目名称：OJ   
* 类名称：jsk_greedy_02   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月24日 上午11:03:38   
* @version        
*/
public class jsk_greedy_02{
    
    public static int lap[];
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        lap = new int[n];

        for(int i = 0; i < n; i++){
            lap[i] = scan.nextInt();
        }
        Arrays.sort(lap);

        int count = 0;//记录关灯的数量
        int left = 0;//记录左边最近的亮着的灯的下标
        for(int i = 1; i < n - 1; i++){
            if(lap[i+1] - lap[left] <= m){
            	//左右最近两盏亮着的灯的距离不超过m，
            	//把当前灯lap[i]熄灭，计数
            	//因为当前灯lap[i]熄灭了，对于下一盏灯lap[i+1]来说，
            	//它左边最近的亮着的灯也是lap[left]
            	//所有不用更新  left 的值
                count++;
            }else{
            	//当前灯lap[i]不熄免熄灭
            	//那么下一盏灯lap[i+1]的左边最近的亮着的灯就是现在的lap[i]
                left = i;
            }
        }
        
		System.out.print(count);
    
    }
}
