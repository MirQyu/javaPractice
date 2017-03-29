package niuke;


public class QuickPower {
	
	public static void main(String[] args) {
		QuickPower qPower = new QuickPower();
		System.out.println("result is " + qPower.getPower(2, 3));
//		long l1 = 1000000007, l2 = 1000000007;
//		System.out.println(l1 * l2);
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(1000000007);
//		System.out.println(65536*65536);
		int[][] arrs = new int[3][];
	}
	
	public int getPower(int k, int N) {
        // write code here
        // 保存N的二进制， 从低位到高位
        int[] arr = new int[32];
        // 保存以K为base的 对应位的 幂次 k^(2^arr[i])
        long[] pows = new long[32];
        int size = 0;
        
        
        
        long p = k;
        pows[size] = p;
        
        int co = N;
        arr[size++] = co & 1;
        
        co >>= 1;
         
        while (co > 0) {

            p = p * p % 1000000007;
            pows[size] = p;
            
            arr[size++] = co & 1;
            // 二分搜索。
            co >>= 1;
        }
        
        long res = 1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 1) {
                res = res * pows[i] % 1000000007;
            }
            
        }
        return (int) res;
    }
}