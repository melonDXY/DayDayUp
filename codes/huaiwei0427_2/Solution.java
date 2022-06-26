package codes.huaiwei0427_2;

import java.util.*;

public class Solution {
    public static class TreeNode{  // 定义二叉树结构
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 对输入数组及字符串的处理
        String str1 = in.nextLine();
        String[] s1 = str1.substring(1, str1.length() - 1).split(",");
        // 根二叉树数组
        int[] num1 = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            num1[i] = Integer.parseInt(s1[i]);
        }
        // 字符串，子二叉树根节点对应根二叉树节点
        String str2 = in.nextLine();
        String[] s2 = str2.substring(1, str2.length()).split("/");
        int[] num2 = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            num2[i] = Integer.parseInt(s2[i]);
        }
        String str3 = in.nextLine();
        String[] s3 = str3.substring(1, str3.length() - 1).split(",");
        // 子二叉树数组
        int[] num3 = new int[s3.length];
        for (int i = 0; i < s3.length; i++) {
            num3[i] = Integer.parseInt(s3[i]);
        }
        
        // 建树
        TreeNode treeNode1 = Build(num1,0);
        TreeNode treeNode2 = Build(num3, 0);
        if (num2.length > 1) {  // 进行子树替换
            replace(treeNode1, treeNode2, num2, 1);
        } else {
            treeNode1 = treeNode2;
        }
        // 层序遍历输出结果
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode1);

        String ans = "[";
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans = ans + node.val + "," ;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        ans = ans.substring(0, ans.length() - 1) + "]";
        System.out.println(ans);

    }
    // 建树
    public static TreeNode Build(int[] nums, int index){
        TreeNode newNode = null;
        if(index < nums.length){
            if(nums[index] != 0){  // 可以判断null（换成字符串数组），可以判断-1
                newNode = new TreeNode(nums[index]);
                newNode.left = Build(nums, 2 * index + 1);
                newNode.right = Build(nums, 2 * index + 2);
            }
        }
        return newNode;
    }
    // 替换子树
    public static void replace(TreeNode root1, TreeNode root2, int[] path, int i) {
        if (i == path.length - 1) {
            if (root1.left != null && root1.left.val == path[i]) {
                root1.left = root2;
                return;
            } else if(root1.right != null && root1.right.val == path[i]) {
                root1.right = root2;
                return;
            }
        }

        if (root1.left != null && root1.left.val == path[i]) {
            replace(root1.left, root2, path, i + 1);
        } else if (root1.right != null && root1.right.val == path[i]) {
            replace(root1.right, root2, path, i + 1);
        }
    }
}
