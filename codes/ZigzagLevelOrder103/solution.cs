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
    public IList<IList<int>> ZigzagLevelOrder(TreeNode root) {
        var res = new List<IList<int>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        bool isReverse = false;
        while(queue.Count > 0){
            var curLevel = new List<int>();
            int nums = queue.Count;
            for(int i = 0; i < nums; ++ i){
                TreeNode curNode = queue.Dequeue();
                if(curNode.left != null){
                    queue.Enqueue(curNode.left);
                }
                if(curNode.right != null){
                    queue.Enqueue(curNode.right);
                }
                curLevel.Add(curNode.val);
            }
            if(isReverse){
               curLevel.Reverse();
            }
            res.Add(curLevel);
            isReverse = !isReverse;
        }
        return res;
    }
}