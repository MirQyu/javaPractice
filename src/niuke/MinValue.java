package niuke;

public class MinValue {
    public int getMin(int[] arr, int n) {
        // write code here
        if (arr == null || arr.length == 0)
            return -1;
        
        if (arr.length == 1)
            return arr[0];
        
        if (arr[0] < arr[arr.length-1])
            return arr[0];
        
        int start = 0, end = arr.length-1;

        // arr[start] >= arr[end]
        while (start <= end && arr[start] >= arr[end]) {
            if (end - start == 1) {
                return Math.min(arr[start], arr[end]);
            }
            
            
            int mid = start + (end-start)/2;
            
//            if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1])
//                return arr[mid];
            if (arr[mid] > arr[end]) {
                start = mid;
//                start = mid + 1;
            }
            else if (arr[mid] < arr[start]) {
                end = mid;
            }
            else {
                break;
            }
        }
        
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, arr[i]);
        }
        
        return res;
    }
}