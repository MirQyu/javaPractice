package niuke;

public class Learn {
	 
	public int[] heapSort(int[] A, int n) {
        // write code here
        for(int i=n/2; i>=0; i--){
            heapAdjust(A,i,n);
        }
         
        for(int i=n-1;i>0;i--){
            swap(A,0,i);
            heapAdjust(A,0,i);
        }
        return A;
    }
     
    void heapAdjust(int[] A,int index,int length){
        int childLeft;
        int temp = A[index];
        for( ;index*2+1 < length;index = childLeft){
            childLeft = index*2+1;
            if(childLeft !=length-1 && A[childLeft] < A[childLeft+1]){
                 childLeft++;
            }
            if(temp > A[childLeft]){
                break;
                 
            }                
            else {
                A[index] = A[childLeft];
                index = childLeft;
            }           
        }
         A[index] = temp;
         
    }
     
    static void  swap(int[] A,int m,int n){
        int temp = A[m];
        A[m] = A[n];
        A[n] = temp;
    }
    
}
