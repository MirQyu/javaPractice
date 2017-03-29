package niuke;

public class LeftMostAppearance {
	public int findPos(int[] arr, int n, int num) {
        // write code here
        
        int start = 0, end = arr.length-1;
        int lastIndex = -1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] < num) {
                start = mid + 1;
            }
            else if (arr[mid] > num) {
                end = mid - 1;
            }
            else {
            	lastIndex = mid;
                end = mid - 1;
            }
        }
        
        return lastIndex;
    }
}
