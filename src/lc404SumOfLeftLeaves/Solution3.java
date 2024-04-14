package lc404SumOfLeftLeaves;

import lc100SameTree.TreeNode;

public class Solution3 {

    public static void main(String[] args) {

    }

    private static boolean isLeaf(TreeNode node){
        return (node != null) && (node.left == null) && (node.right == null);
    }
    private static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
       return getSumOfLeftLeaves(root, false);
    }

    private static int getSumOfLeftLeaves(TreeNode root, boolean isLeft) {

        if(root == null){
            return 0;
        }
        // Base case: This is a leaf node.
        // Base case: This is a leaf node.
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        // Recursive case: We need to add and return the results of the
        // left and right subtrees.
        return getSumOfLeftLeaves(root.left, true) + getSumOfLeftLeaves(root.right, false);
    }
}
