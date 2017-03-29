package niuke;

public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        // write code here
        // 时间复杂度 O(n + m)
        int row = 0;
        int column = m-1;
        
        while (row < n && column > -1) {
            if (mat[row][column] == x)
                return true;
            if (x > mat[row][column]) {
                row++;
            }
            else {
                column--;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
    	
	}
}
