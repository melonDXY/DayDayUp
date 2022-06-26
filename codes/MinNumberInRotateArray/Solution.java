package codes.MinNumberInRotateArray;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;

        
        while (left < right){
            int mid = (left + right)/2;
            
            if(array[mid] > array[mid + 1]){
                return array[mid + 1];
            }else{
                left = mid + 1;
            }

        }
        return array[left];
    }
}