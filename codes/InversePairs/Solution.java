package codes.InversePairs;

public class Solution {

    public int mergeSort(int[] array, int[] temp, int left, int right){
        int res = 0;
        if ( left >= right) {
            return 0;
        }

        int mid = (left + right)/2;
        res = mergeSort(array, temp, left, mid) + mergeSort(array, temp, mid + 1, right);
        res = res % 1000000007;
        int pointL = left;
        int pointR = mid + 1;

        for (int i = 0; i <= right; i++){
            temp[i] = array[i];
        }

        for(int i = 0; i <= right; i++){
            if ( pointL == mid + 1){
                array[i] = temp[pointR];
                pointR++;
                continue;
            }
            if ( pointR == right + 1){
                array[i] = temp[pointL];
                pointL++;
                continue;
            }
            if(temp[pointL] <= temp[pointR]){
                array[i] = temp[pointL];
                pointL++;
            }else{
                res += mid - pointL + 1;
                array[i] = temp[pointR];
                pointR++;
            }
        }

        return res % 1000000007;

        

    }
    public int InversePairs(int [] array) {
        int arrLength = array.length;
        int[] help = new int[arrLength];
        return mergeSort(array, help, 0, arrLength - 1);
    }
}