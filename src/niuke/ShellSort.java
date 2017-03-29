package niuke;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        for (int step = 20; step > 0; step--) {
            sort(A, n, step);
        }
        
        return A;
    }
    
    public static void sort(int[] A, int n, int step) {
        for (int i = step; i < n; i++) {
            int currentIndex = i;
            for (int j = i - step; j >= 0; j = j-step) {
                if (A[currentIndex] < A[j]) {
                    swap(A, currentIndex, j);
                    currentIndex = j;
                }
                else
                    break;
            }
        }
    }
    
    public static void swap(int[] A, int s1, int s2) {
        int temp = A[s1];
        A[s1] = A[s2];
        A[s2] = temp;
    }
}
