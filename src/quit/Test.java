package quit;

import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		char[] chs = s.toCharArray();
		
		int[] arr = new int[chs.length];
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = chs[i];
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println(time);
	}
	
	
	static int time = 0;
	
	static void mergeSort(int[] A, int start, int len) {
		if (len == 1)
			return;
		
		int mid = len / 2;
		int left = start, right = start + mid;
		mergeSort(A, left, mid);
		mergeSort(A, right, len-mid);
		
		merge(A, left, right, len);
	}
	
	/**
	 * 归并的总长度
	 */
	static void merge(int[] A, int left, int right, int len) {
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
				time++;
				result[k++] = A[hight++];
			}
		}
		
		while (low < left+leftLenth) {
			time++;
			result[k++] = A[low++];
		}
		
		while (hight < right + rightLenth) {
			result[k++] = A[hight++];
		}
		
		for (int i = 0; i < k; i++) {
			A[left++] = result[i];
		}
	}
}
