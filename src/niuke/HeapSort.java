package niuke;

import java.util.ArrayList;
import java.util.Random;

public class HeapSort {

	public static void main(String[] args) {
		Random random = new Random();
		Integer[] arrays = new Integer[100];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = random.nextInt(100) + 1;
		}
		heapSort(arrays);
		
		for (int i = 0; i < arrays.length; i++)
			System.out.print(arrays[i] + " ");
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		Heap<E> heap = new Heap<>(list);
		for (int i = list.length-1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
	
	/**
	 * 最大堆
	 * @author MirQ
	 *
	 * @param <E>
	 */
	public static class Heap<E extends Comparable<E>> {
		java.util.ArrayList<E> list = new ArrayList<>();
		boolean isMaxHeap = true;
		
		
		public Heap() {
		}
		
		public Heap(E[] arrays) {
			this(arrays, true);
		}
		
		public Heap(E[] arrays, boolean isMaxHeap) {
			for (int i = 0; i < arrays.length; i++)
				add(arrays[i]);
			
			isMaxHeap = false;
		}
		
		public void add(E e) {
			list.add(e);
			int currentIndex = list.size() - 1;
			
			while (currentIndex > 0) {
				int parentIndex = (currentIndex-1) / 2;
				if (e.compareTo(list.get(parentIndex)) > 0) {
					swap(currentIndex, parentIndex);
					currentIndex = parentIndex;
				}
				else
					break;
			}
		}
		
		public E remove() {
			if (size() == 0)
				return null;
			
			if (size() == 1) 
				return list.remove(0);
			
			E result = list.get(0);
			E element = list.get(list.size() - 1);
			list.set(0, element);
			list.remove(list.size() - 1);
			
			int currentIndex = 0;
			while (currentIndex < list.size()) {
				int leftChild = currentIndex*2 + 1;
				
				int rightChild = currentIndex*2 + 2;
				
				// 这里代码有点冗长
				if (leftChild < list.size()) {
					if (rightChild < list.size()) { // 两孩子都有
						int maxChild = max(leftChild, rightChild);
						
						if (list.get(currentIndex).compareTo(list.get(maxChild)) < 0) {
							swap(currentIndex, maxChild);
							currentIndex = maxChild;
						}
						else
							break;
					}
					else {	// 只有左孩子了, 最后一次比较吧？
						if (list.get(currentIndex).compareTo(list.get(leftChild)) < 0) {
							swap(currentIndex, leftChild);
						}
						break;	
					}
				}
				else
					break;
			}
			
			return result;
		}
		
		public int max(int s1, int s2) {
			E e1 = list.get(s1);
			E e2 = list.get(s2);
			if (e1.compareTo(e2) >= 0)
				return s1;
			else
				return s2;
		}

		public int size() {
			return list.size();
		}
		
		private void swap(int s1, int s2) {
			E temp = list.get(s2);
			list.set(s2, list.get(s1));
			list.set(s1, temp);
		}
		
	}
	
}
