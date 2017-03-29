package niuke;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		// 长度的概念
//		int min = 45, max = 9980;
//		int n = 427;
//		int a = 9970;
//		double interval = 23.0;
//		System.out.println((a-min)/((max-min)/n));
		
//		Set<String> set = new HashSet<>();
//		String str1 = new String("fuck"), str2 = new String("fuck");
//		set.add(str1);
//		System.out.println(set.contains(str2));
		System.out.println('e' - 'a');
		qyu.Utility.print(false);
		int[] array = new int[]{1,2,3};
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
		
	}
	
	public static int[] heapSort(int[] A, int n) {
        // write code here
        Heap heap = new Heap(A, n);
        for (int i = n-1; i >= 0; i--) {
        	A[i] = heap.remove();
        }
            
        
        return A;
    }
    
    public static class Heap {
		int[] list;
		int size;
		
		
		public Heap(int[] arrays, int n) {
			list = new int[n];
			for (int i = 0; i < n; i++)
				add(arrays[i]);
		}
		
		public void add(int e) {
			list[size++] = e;
			int currentIndex = size - 1;
			
			while (currentIndex > 0) {
				int parentIndex = (currentIndex-1) / 2;
				if (e > list[parentIndex]) {
					swap(currentIndex, parentIndex);
					currentIndex = parentIndex;
				}
				else
					break;
			}
		}
		
		public int remove() {
			if (size() == 0)
				return -1;
			
			int result = list[0];
			
			if (size() == 1) {
				size = 0;
				return result;
			}
				
			int element = list[size - 1];
			list[0] = element;
			size--;
			
			int currentIndex = 0;
			while (true) {
				int leftChild = currentIndex*2 + 1;
				
				if (leftChild < size()) {
					int rightChild = currentIndex*2 + 2;
					
					if (rightChild < size()) { // 两孩子都有
						int maxChild = max(leftChild, rightChild);
						
						if (list[currentIndex] < list[maxChild]) {
							swap(currentIndex, maxChild);
							currentIndex = maxChild;
						}
						else
							break;
					}
					else {	// 只有左孩子了, 最后一次比较吧？
						if (list[currentIndex] < list[leftChild]) {
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
			int e1 = list[s1];
			int e2 = list[s2];
			if (e1 >= e2)
				return s1;
			else
				return s2;
		}

		public int size() {
			return size;
		}
		
		private void swap(int s1, int s2) {
			int temp = list[s2];
			list[s2] = list[s1];
			list[s1] = temp;
		}
		
	}
}
