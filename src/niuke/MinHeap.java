package niuke;

import java.util.Random;

public class MinHeap<E extends Comparable<E>> {
	E[] heap;
	int size;
	
	public MinHeap(E[] array) {
		this.heap = array;
		size = array.length;
		
		for (int i = size/2; i >= 0; i--)
			heapAdjust(i);
	}
	
	public E remove() {
		E min = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapAdjust(0);
		
		return min;
	}
	
	public void add(E element) {
		heap[size++] = element;
		int currentIndex = size-1;
		
		// 有父亲
		while (currentIndex >= 1) {
			int parentIndex = (currentIndex-1) / 2;
			if (heap[currentIndex].compareTo(heap[parentIndex]) < 0) {
				E temp = heap[parentIndex];
				heap[parentIndex] = heap[currentIndex];
				currentIndex = parentIndex;
			}
			else
				break;
		}
	}
	
	
	private void heapAdjust(int index) {
		while (index < size/2) {
			int minChild = 2*index + 1;
			int rightChild = 2*index + 2;
			if (rightChild < size)
				minChild= (heap[rightChild].compareTo(heap[minChild]) <= 0) ? rightChild : minChild;
			
			if (heap[minChild].compareTo(heap[index]) < 0) {
				E temp = heap[index];
				heap[index] = heap[minChild];
				heap[minChild] = temp;
				
				index = minChild;
			}
			else
				break;
		}
	}
	
	public E[] heapSort() {
		int length = size;
		// n-1次 
		for (int i = 1; i < length; i++) {
			E min = heap[0];
			heap[0] = heap[size-1];
			heap[size-1] = min;
			size--;
			heapAdjust(0);
		}
		
		size = length;
		return heap;
	}
	
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] array = new Integer[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100) + 1;
		}
		
		MinHeap<Integer> heap = new MinHeap<>(array);
		heap.heapSort();
		
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
	
}
