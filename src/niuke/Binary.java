package niuke;

public class Binary {

	public static void main(String[] args) {
		Math.min(0, 1);
	}
	
	public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
		if (arr.length == 1)
            return 0;
        
        if (arr[0] < arr[1])
            return 0;
        
        if (arr[arr.length-1] < arr[arr.length-2])
            return arr.length-1;
        
        
        int start = 0, end = arr.length - 1;
        
        
        while(true) {
            int mid = start + (end-start)/2;
            if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
                return mid;
            }
            
            else if (arr[mid] > arr[mid+1]) {
                start = mid;
            }
            else if (arr[mid] > arr[mid-1]) {
                end = mid;
            }
        }
    }
	
}
