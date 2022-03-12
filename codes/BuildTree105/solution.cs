/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    Dictionary<int, int> valueIndex = new Dictionary<int, int>();
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        int length = inorder.Length;
        if(length == 1){
            return new TreeNode(inorder[0]);
        } else if(length == 0){
            return null;
        }
        for(int i = 0; i < length; ++ i){
            valueIndex.Add(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int indexInInorder = valueIndex[preorder[0]];
        root.left = MyBuildTree(preorder, 1, indexInInorder, inorder, 0, indexInInorder - 1);
        root.right = MyBuildTree(preorder, indexInInorder + 1, length - 1, inorder, indexInInorder + 1, length - 1);
        return root;
    }

    public TreeNode MyBuildTree(int[] preorder,int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preLeft == preRight)
            return new TreeNode(preorder[preLeft]);
        else if(preLeft > preRight)
            return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int indexInInorder = valueIndex[root.val];
        int leftLength = indexInInorder - inLeft;
        int rightTreeRoot = preLeft + leftLength + 1;
        root.left = MyBuildTree(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft, indexInInorder - 1);
        root.right = MyBuildTree(preorder, preLeft + leftLength + 1, preRight, inorder, indexInInorder + 1, inRight);
        return root;
    }
}