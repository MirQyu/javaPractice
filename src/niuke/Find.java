package niuke;

public class Find {

	public int findPos(int[] arr, int n) {
        // write code here
        if (arr == null | arr.length == 0)
            return -1;
        
        if (arr[0] > n-1 || arr[n-1] < 0)
            return -1;
        
        int start = 0, end = n-1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] > mid) {
                end = mid - 1;
            }
            else if (arr[mid] < mid) {
                start = mid + 1;
            }
            else {
            	if (res != -1) {
                    res = Math.min(res, mid);
                    end = mid - 1;
                }
                else {
                    res = mid;
                }
            }
        }
        
        return res;
    }
}
