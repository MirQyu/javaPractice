package niuke;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (iniString.charAt(i) == ' ')
                num++;
        }
        
        char[] chs = new char[length + 2*num];
        int index = chs.length - 1;
        for (int i = length-1; i >=0; i--) {
            if (iniString.charAt(i) == ' ') {
                chs[index--] = '0';
                chs[index--] = '2';
                chs[index--] = '%';
            }
            else {
                chs[index--] = iniString.charAt(i);
            }
        }
        
        return String.valueOf(chs);
    }
}
