package niuke;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Prior implements Comparator<String> {
	
	public static void main(String[] args) {
		String[] strs = {"10", "fuck", "come"};
		List<String> list = Arrays.asList(strs);
		list.set(0, "you");
		
		qyu.Utility.printArray(strs);
	}
	
	public String findSmallest(String[] strs, int n) {
        // write code here
        List<String> list = Arrays.asList(strs);
		Collections.sort(list, this);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append(strs[i]);
		}
		
		return builder.toString();
    }

	@Override
	public int compare(String s1, String s2) {
		String cand1 = s1 + s2, cand2 = s2 + s1;
		if (cand1.compareTo(cand2) < 0)
			return -1;
		else if(cand1.compareTo(cand2) == 0)
			return 0;
		else
			return 1;
	}
	
}
