package practice.jsk05;

public class t04 {

	private static long[] nums;

	public static void main(String[] args) {

		nums = new long[20200210];
		nums[1] = 1;
		nums[2] = 1;
		nums[3] = 1;
		for(int i = 4; i <= 20200202; i++){
			nums[i] = (7 * nums[i-1] + 10 * nums[i-2] + 6 * nums[i-3]) % 998244353;
		}
		System.out.println(nums[20200202]);
		System.out.println("int的最大值：" + Integer.MAX_VALUE);
		
	}

}
