package codes.huaiwei0427_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class MySolution {
    
    public static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private String val;
        TreeNode(String val){
            this.val = val;
        }
    }

    public static TreeNode buildTree(String[] nums, int index){
        TreeNode newNode = null;
        
        if(index < nums.length) {
            if(!nums[index].equals("0")){
                newNode = new TreeNode(String.valueOf(nums[index]));
            newNode.left = buildTree(nums, 2 * index + 1);
            newNode.right = buildTree(nums, 2 * index + 2);
            }
            
        }

        return newNode;
    }

    public static void replaceTree(TreeNode rootTree, TreeNode subTree, String[] path, int i){
        if (i == path.length - 1){
            if(rootTree.left != null && rootTree.left.val.equals(path[i])){
                rootTree.left = subTree;
            }
            else if(rootTree.right != null && rootTree.right.val.equals(path[i])){
                rootTree.right = subTree;
            }
        }
        
        if (rootTree.left != null && rootTree.left.val.equals(path[i])){
            replaceTree(rootTree, subTree, path, i + 1);
        }
        else if(rootTree.right != null && rootTree.right.val.equals(path[i])){
            replaceTree(rootTree, subTree, path, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sRoot = sc.nextLine();
        String sPath = sc.nextLine();
        String sSub = sc.nextLine();

        String[] rootNums = sRoot.substring(1, sRoot.length() - 1).split(",");
        String[] path = sPath.substring(1,sPath.length()).split("/");
        String[] subNums = sSub.substring(1, sSub.length() - 1).split(",");

        TreeNode rootTree = buildTree(rootNums, 0);
        TreeNode subTree = buildTree(subNums, 0);
        if(path.length > 1){
            replaceTree(rootTree, subTree, path, 1);
        }else{
            rootTree = subTree;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootTree);
        StringBuffer ans = new StringBuffer("[");
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.append(node.val).append(",");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.append("]");
        String res = ans.toString();
        System.out.println(res);
    }
}
