package niuke;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.plaf.IconUIResource;

public class Sort {
	public static void main(String[] args) {
		Sort t = new Sort();
		Random random = new Random();
		int[] A = new int[10];
		for (int i = 0; i < 10; i++) {
			A[i] = random.nextInt(100);
		}
		
		t.quickSort(A, 0, 9);
		
		for (int i = 0; i < 10; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	public int[] bubbleSort(int[] A, int n) {
        // write code here
        for (int i = n-1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (A[maxIndex] < A[j]) {
                    maxIndex = j;
                }
            }
            
            int temp = A[i];
            A[i] = A[maxIndex];
            A[maxIndex] = temp;
        }
        
        return A;
    }
	
	public int[] insertionSort(int[] A, int n) {
        // write code here
        // step = 1
        for (int i = 1; i < n; i++) {
            int currentIndex = i;
            for (int j = i-1; j >= 0; j--) {
                if (A[currentIndex] < A[j]) {
                    int temp = A[j];
                    A[j] = A[currentIndex];
                    A[currentIndex--] = temp;
                }
                else
                    break;
            }
        }
        
        return A;
    }
	
	public int[] mergeSort(int[] A, int n) {
        // write code here
		if (A == null || n == 0)
			return A;
		mergeSort(A, 0, n);
		
		return A;
    }
	
	public void mergeSort(int[] A, int start, int len) {
		if (len == 1)
			return;
		
		int mid = len / 2;
		int left = start, right = start + mid;
		mergeSort(A, left, mid);
		mergeSort(A, right, len-mid);
		
		merge(A, left, right, len);
	}
	
	/**
	 * len 一共的长度
	 */
	public void merge(int[] A, int left, int right, int len) {
		int low = left, hight = right;
		int leftLenth = right - left;
		int rightLenth = len - leftLenth;
		
		int[] result = new int[len];
		int k = 0;
		while (low < left + leftLenth && hight < right + rightLenth) {
			if (A[low] <= A[hight]) {
				result[k++] = A[low++];
			}
			else {
				result[k++] = A[hight++];
			}
		}
		
		while (low < left+leftLenth) {
			result[k++] = A[low++];
		}
		
		while (hight < right + rightLenth) {
			result[k++] = A[hight++];
		}
		
		for (int i = 0; i < k; i++) {
			A[left++] = result[i];
		}
	}
	/**
	 * 空间复杂度  O(logN) ~ O(N)
	 * [start, end]
	 * @param A
	 * @param start
	 * @param end
	 */ 
	public void quickSort(int[] A, int start, int end) {
		if (end <= start)
			return;
	
		int p = partition(A, start, end);
		quickSort(A, start, p-1);
		quickSort(A, p+1, end);
	}

	// end 点 为基准点 benchmark
	private int partition(int[] A, int start, int end) {
		int lessThanEqual = start;
		int greaterThan = end - 1;
		
		while (lessThanEqual <= greaterThan) {
			while (lessThanEqual < end && A[lessThanEqual] <= A[end])
				lessThanEqual++;
			while (greaterThan >= 0 && A[greaterThan] > A[end])
				greaterThan--;
			
			if (lessThanEqual < greaterThan) {
				int temp = A[lessThanEqual];
				A[lessThanEqual] = A[greaterThan];
				A[greaterThan] = temp;
			}
		}
		
		if (lessThanEqual != end) {
			int temp = A[end];
			A[end] = A[lessThanEqual];
			A[lessThanEqual] = temp;
		}
		
		return lessThanEqual;
	}
	
		
}
