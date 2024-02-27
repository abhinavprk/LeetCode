package lc543DiameterOfBinaryTree;

import lc100SameTree.TreeNode;

public class Solution1 {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);

        diameter = Math.max(leftPath +rightPath, diameter);
        return Math.max(leftPath, rightPath) +1;
    }


}
