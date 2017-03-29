package niuke;


public class Reverse {
	public String reverseSentence(String A, int n) {
        // write code here
        String[] strArray = A.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strArray.length - 1; i >= 0; i--) {
        	builder.append(strArray[i] + ' ');
        }
        
        return builder.substring(0, n);
    }
	
//	public String reverseSentence2(String A, int n) {
//        // write code here
//       String[] splits = A.split(" ");
//       StringBuilder builder = new StringBuilder();
//       for (int i = 0; i < splits.length; i++) {
//           builder.append(reverse(splits[i] + " "));
//       }
//       return reverse(builder.substring(0, builder.length() - 1));
//    }
	
	public String reverse(char[] sChars) {
		
		for (int i = 0; i < sChars.length / 2; i++) {
			char temp = sChars[i];
			sChars[i] = sChars[sChars.length - 1 - i];
			sChars[sChars.length - 1 - i] = temp;
		}
		
		return new String(sChars);
	}
	
	public static void main(String[] args) {
		char[] chs = {'q', 'e', 'r'};
		System.out.println(new String(chs));
	}
	
	// [start, end]
	public void reverse(char[] chs, int start, int end) {
		while (start < end) {
			char temp = chs[start];
			chs[start++] = chs[end];
			chs[end--] = temp;
		}
	}
	
	public String stringTranslation(String A, int n, int len) {
        // write code here
		char[] chs = A.toCharArray();
		reverse(chs, 0, len-1);
		reverse(chs, len, n-1);
		reverse(chs, 0, n-1);
		
		return new String(chs);
    }
}
