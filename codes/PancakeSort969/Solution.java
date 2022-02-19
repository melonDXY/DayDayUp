package codes.PancakeSort969;
import java.util.ArrayList;
import java.util.List;

class Solution {
    //煎饼排序，注意的是数组内元素最大值的是数组的长度，根据最大值递减找元素来排序
    public List<Integer> pancakeSort(int[] arr) { 
        List<Integer> ans = new ArrayList<Integer>();
        int arrLen = arr.length;
        int last = arrLen;
        for(int i = arrLen - 1; i >= 0 ; i--){
            if(arr[i] == last){
                last--;
                
                continue;
            }
            if(arr[0] == last){
                reverse(arr, 0, i);
                last--;
                ans.add(i+1);
                continue;
            }
            for(int k = 0; k < last; k++){
                if(arr[k] != last){
                    continue;
                }
                reverse(arr, 0, k);
                ans.add(k+1);
                reverse(arr, 0, i);
                ans.add(i+1);
                break;
            }
            last--;
            
        }
        
        return ans;
    }

    public void reverse(int[] arr, int startIndex, int endIndex){
        for(int i = startIndex; i<(endIndex - startIndex+1)/2; i++){
            int temp = arr[i];
            arr[i] = arr[endIndex-i];
            arr[endIndex-i] = temp;
        }
    }

    public void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4,1};
        Solution solution = new Solution();
        System.out.println(solution.pancakeSort(nums));
    }
}