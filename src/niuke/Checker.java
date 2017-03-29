package niuke;

import java.util.*;

import qyu.Utility;

public class Checker {
	
	public static void main(String[] args) {
		Random random = new Random(100);
		
		int[] array = new int[20];
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(30) + 1;
		Utility.printArray(array);
		Checker checker = new Checker();
		System.out.println(checker.checkDuplicate(array, array.length));
	}
    public boolean checkDuplicate(int[] A, int n) {
        // write code here
        MaxHeap heap = new MaxHeap();
        heap.buildHeap(A, n);
        heap.sort();
        
        System.out.println("完成排序");
        Utility.printArray(A);
        
        
        for (int i = 0; i < n-1; i++) {
            if (A[i] == A[i+1]) {
                return true;
            }
        }
        return false;
    }
    
    public static class MaxHeap {
        int[] heap;
        int size;
        
        public void buildHeap(int[] array, int n) {
            heap = array;
            size = n;
            
            for (int i = size/2 - 1; i >= 0; i--) {
                heapAdjust(i);
            }
        }
        
        public int[] sort() {
            int length = size;
            for (int i = 1; i < length; i++) {
                swap(0, --size);
                heapAdjust(0);
            }
            
            return heap;
        }
        
        public void heapAdjust(int index) {
        	
            while (index < size/2) {
                int maxChildIndex = index*2 + 1;
                int rightChildIndex = index*2 + 2;
                if (rightChildIndex < size)
                	maxChildIndex = (heap[rightChildIndex] > heap[maxChildIndex]) ? rightChildIndex : maxChildIndex;
                
                if (heap[index] < heap[maxChildIndex]) {
                    swap(index, maxChildIndex);
                    index = maxChildIndex;
                }
                else
                    break;
            }
        }
        
        public void swap(int s1, int j) {
            int temp = heap[s1];
            heap[s1] = heap[j];
            heap[j] = temp;
        }
    }
}