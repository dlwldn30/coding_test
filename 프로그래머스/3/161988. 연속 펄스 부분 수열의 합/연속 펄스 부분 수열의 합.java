import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int n = sequence.length;
        
        long[] arr1 = new long[n];
        long[] arr2 = new long[n];
        
        for(int i = 0; i < n; i++){
            if(i%2 == 0){
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            }else{
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            }
        }
        
        return Math.max(kadane(arr1), kadane(arr2));

    }
    
    private long kadane(long[] arr){
        
        long max = arr[0];
        long cur = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            
            cur = Math.max(arr[i], cur + arr[i]);
            
            max = Math.max(cur, max);
        }
        
        return max;
    }
}