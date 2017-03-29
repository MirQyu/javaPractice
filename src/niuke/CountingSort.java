package niuke;

import java.util.ArrayList;
import java.util.Random;

public class CountingSort {
	
	public static void main(String[] args) {
		CountingSort cSort = new CountingSort();
		int[] A = new int[10];
		Random random = new Random(100);
		for (int i = 0; i < A.length; i++) {
			A[i] = random.nextInt(20) + 1;
		}
		
		A = cSort.countingSort(A, A.length);
		
		for (int i = 0; i < A.length; i++)
			System.out.println(A[i] + " ");
		
	}
    public int[] countingSort(int[] A, int n) {
    	// 自己找范围， min, max
    	
        int min = A[0], max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }
        
        System.out.println("min = " + min + ", max = " + max);
        
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < bucket.length; i++)
        	bucket[i] = 0;
        
        for (int i = 0; i < n; i++) {
        	bucket[A[i] - min]++;
        }
        
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
        	System.out.println("j = " + j);
        	while (bucket[j] != 0) {
        		bucket[j]--;
        		A[i++] = j + min;
        	}
        }
        
        return A;
    }
    
    static ArrayList<Integer>[] bucket = new ArrayList[10];
    
    public int[] radixSort(int[] A, int n) {

        for (int i = 0; i < bucket.length; i++)
            bucket[i] = new ArrayList<>();
    	
    	for (int i = 1; i <= 4; i++) {
    		rSort(A, n, i);
    	}
    	
    	return A;
    	
    }
    
    public void rSort(int[] A, int n, int pos) {
    	
    	
    	for (int i = 0; i < n; i++) {
    		int value = getPosValue(A[i], pos);
    		bucket[value].add(A[i]); 
    	}
    	
    	int index = 0;
    	for (int i = 0; i < bucket.length; i++) {
    		for (int j = 0; j < bucket[i].size(); j++) {
    			A[index++] = bucket[i].get(j); 
    		}
    		bucket[i].clear();
    	}
    }
    
    /**
     * 得到第几位元素， 从1开始计数
     * @param num
     * @param pos
     * @return
     */
	private int getPosValue(int num, int pos) {
		for (int i = 1; i < pos; i++) {
			num /= 10;
		}
		return num % 10;
	}
    
}
