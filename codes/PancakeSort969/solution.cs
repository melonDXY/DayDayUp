public class Solution {
    public IList<int> PancakeSort(int[] arr) {
        IList<int> res = new List<int>();
        for(int n = arr.Length; n > 1; -- n){
            int idx = 0;
            // 寻找当前范围最大值
            for(int i = 1; i < n; ++ i){
                if(arr[i] >= arr[idx]){
                    idx = i;
                }
            }
            if(idx == n - 1){
                // 最大值已在末尾处，无需翻转
                continue;
            }
            // 两步翻转将最大值移至末尾
            Reverse(arr, idx);
            Reverse(arr, n - 1);
            // 记录k值序列
            res.Add(idx + 1);
            res.Add(n);
        }
        return res;
    }

    public void Reverse(int[] arr, int range){
        for(int i = 0, j = range; i < j; ++ i, -- j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}