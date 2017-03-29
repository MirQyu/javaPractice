package niuke;

public class Transform {
	public boolean chkTransform(String A, int lena, String B, int lenb) {
        int[] table = new int[26];
        for (int i = 0; i < lena; i++) {
            table[A.charAt(i) - 'a']++;
        }
        
        for (int j = 0; j < lenb; j++) {
        	table[B.charAt(j) - 'a']--;
        }
        
        for (int k = 0; k < table.length; k++) {
        	if (table[k] != 0)
        		return false;
        }
        
        return true;
        
    }
}
