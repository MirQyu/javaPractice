package niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> helpStack = new ArrayList<>();
        
        
        int top = numbers.length-1;
        
        while (top != -1) {
            int current = numbers[top--];	// pop
            while (helpStack.size() > 0 && current > helpStack.get(helpStack.size() - 1)) {
            	numbers[++top] = helpStack.remove(helpStack.size() - 1);
            }
            
            helpStack.add(current);
        }
        
//        while (!helpStack.isEmpty()) {
//            numbers[++top] = helpStack.remove(helpStack.size() - 1);
//        }
        
        
        return helpStack;
    }
    
    public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < 4; i++) {
			map.put(String.valueOf(i), String.valueOf(i*i));
		}
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			entry.getKey();
		}
	}
}
