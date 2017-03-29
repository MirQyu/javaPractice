package niuke;

import qyu.Utility;
import java.util.Random;

public class ScaleSort {
	
	public static void main(String[] args) {
		ScaleSort ss = new ScaleSort();
		
		Random random = new Random();
		
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100) + 1;
		
		MinHeap heap = new MinHeap(array);
		
		for (int i = 0; i < array.length; i++)
			array[i] = heap.remove();
		
		
		
		Utility.printArray(array);
		
	}
	
	public int[] sortElement(int[] A, int n, int k) {
        int[] array = new int[k];
    	for (int i = 0; i < k; i++)
            array[i] = A[i];
        
        MinHeap heap = new MinHeap(array, k);
        for (int i = 0; i < n-k; i++) {
            A[i] = heap.remove();
            heap.add(A[i+k]);
        }
        for (int i = n-k; i < n; i++)
            A[i] = heap.remove();
        
        return A;
    }
    
    public static class MinHeap {
        int[] heap;
        int size;
	
        public MinHeap(int[] array) {
			this(array, array.length);
		}
        
        public MinHeap(int[] array, int n) {
            this.heap = new int[n];

            for (int i = 0; i < n; i++) {
            	add(array[i]);
            }
        }

        public int remove() {
        	
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapAdjust(0);

            return min;
        }

        public void add(int element) {
            heap[size++] = element;
            int currentIndex = size-1;

            // 有父亲
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (heap[currentIndex]< heap[parentIndex]) {
                    swap(currentIndex, parentIndex);
                    currentIndex = parentIndex;
                }
                else
                    break;
            }
        }

		private void swap(int currentIndex, int parentIndex) {
			int temp = heap[parentIndex];
			heap[parentIndex] = heap[currentIndex];
			heap[currentIndex] = temp;
		}
        
        private void heapAdjust(int index) {
        	
            while (index < size/2) {
                int minChild = 2*index + 1;
                int rightChild = 2*index + 2;
                if (rightChild < size)
                    minChild = (heap[rightChild] <= heap[minChild]) ? rightChild : minChild;

                if (heap[minChild] < heap[index]) {
                    swap(minChild, index);

                    index = minChild;
                }
                else
                    break;
            }
		}
    }
    
    

	
}
