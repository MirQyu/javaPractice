package quit;

import java.util.ArrayList;

public class Two {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++)
			list.add(i);
		
		Object[] arr = list.toArray();
		System.out.println(arr[0] instanceof Integer);
		
		
		qyu.Utility.printArray(arr);
		
		System.out.println();
		
		
		
//		Node[] nodes = new Node[10];
//		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
//			nodes[i] = new Node();
//			nodes[i].value = random.nextInt(100);
//			nodes[i].anotherOne = random.nextInt(100);
//		}
//		
//		qyu.Utility.printArray(nodes);
//		
//		Arrays.sort(nodes, new Comparator<Node>() {
//
//			@Override
//			public int compare(Node o1, Node o2) {
//				return o2.value - o1.value;
//			}
//			
//		});
//		
//		qyu.Utility.printArray(nodes);
//		System.out.println(nodes[0].value + " ---- " + nodes[0].anotherOne);
	}
	
	static class Node {
		int value;
		
		int anotherOne;
		
		int right;
		
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + String.valueOf(value) + ", "+String.valueOf(anotherOne) + "]";
		}
	}
	
}

