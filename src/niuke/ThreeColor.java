package niuke;

import qyu.Utility;

public class ThreeColor {
	
	public static void main(String[] args) {
		ThreeColor threeColor = new ThreeColor();
		int[] A = {1,2,0,2};
		threeColor.sortThreeColor(A, 4);
		Utility.printArray(A);
	}
	
    public int[] sortThreeColor(int[] A, int n) {
        int leftBorder = -1;
        int rightBorder = n;
        
        
        for (int index = 0; index < rightBorder; index++) {
        	
            while (A[index] == 2 && index < rightBorder) {
                swap(A, index, --rightBorder);
            }
            
            if (A[index] == 0) {
                swap(A, index, ++leftBorder);
            }
            
        }
        
        return A;
    }
    
    public void swap(int[] A, int c1, int d1) {
        int temp = A[c1];
        A[c1] = A[d1];
        A[d1] = temp;
    }
}