package codes.BinaryFind;

public class Solution {

    public boolean search(int target, int [] arr) {
        int left = 0;
        int right = arr.length - 1;

        while( left <= right) {
            int mid = (left + right)/2;
            if ( arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        
        int cols = array[0].length;
        if ( cols == 0) return false;

        for (int i = 0; i < rows ; i++) {
            if (array[i][0] > target || array[i][cols-1] < target) 
                continue;
            if (search(target, array[i])) return true;
        }
        return false;
        // int right = rows * cols -1;
        // int left = 0;
        // while (left <= right) {
        //     int mid = (right + left)/2;
        //     int mid_r = mid/cols;
        //     int mid_c = mid % cols;
        //     if(array[mid_r][mid_c] == target){
        //         return true;
        //     }
        //     if (array[mid_r][mid_c] < target){
        //         left = mid + 1;
        //     }else{
        //         right = mid - 1;
        //     }
        // }
        // return false;
    }
}