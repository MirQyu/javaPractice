package niuke;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 *	对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
	给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
	测试样例：
	"aabcb",5
	返回：3
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        // write code here
        Map<Character, Integer> map = new HashMap<>();
        int pre = -1;
        int max = -1;
        for (int i = 0; i < n; i++) {
            int indexPrecede, maxIndex, length;
            if (map.containsKey(A.charAt(i))) {
                indexPrecede = map.get(A.charAt(i));
            }
            else {
                indexPrecede = -1;
            }
            
            maxIndex = Math.max(indexPrecede+1, pre);
            length = i - maxIndex + 1;
            if (length > max)
                max = length;
            map.put(A.charAt(i), i);
            pre = maxIndex;
        }
        
        return max;
    }
}
