package niuke;

import java.util.Deque;

import java.util.LinkedList;

public class SlideWindow {
	public int[] slide(int[] arr, int n, int w) {
		int[] res = new int[n-w+1];
		int index = 0;
		
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i < n; ++i) {
			while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
			
			if (i >= w-1) {
				if (deque.getFirst() == i-w) {
					deque.removeFirst();
				}
				res[index++] = arr[deque.getFirst()];
			}
		}
		return res;
		
	}
}
