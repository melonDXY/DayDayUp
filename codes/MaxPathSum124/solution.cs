/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int maxSum = int.MinValue;
    public int MaxPathSum(TreeNode root) {
        GainSum(root);
        return maxSum;
    }

    public int GainSum(TreeNode node){
        if(node == null)
            return 0;

        int leftGain = Math.Max(0, GainSum(node.left));
        int rightGain = Math.Max(0, GainSum(node.right));
        int curSum = node.val + leftGain + rightGain;
        maxSum = Math.Max(maxSum, curSum);
        return node.val + Math.Max(leftGain, rightGain);
    }
}