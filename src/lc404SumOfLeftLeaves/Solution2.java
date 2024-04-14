package lc404SumOfLeftLeaves;

import lc100SameTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

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

        // Base case: This is a leaf node.
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        // Recursive case: We need to add and return the results of the
        // left and right subtrees.
        int total = 0;
        if (root.left != null) {
            total += getSumOfLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            total += getSumOfLeftLeaves(root.right, false);
        }
        return total;
    }
}
