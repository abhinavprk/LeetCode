package lc404SumOfLeftLeaves;

import lc100SameTree.TreeNode;

public class Solution4 {

    public static void main(String[] args) {

    }

    private static int sumOfLeftLeaves(TreeNode root) {
        int totalSum = 0;
        TreeNode currentNode = root;
        while (currentNode != null) {
            // If there is no left child, we can simply explore the right subtree
            // without needing to worry about keeping track of currentNode's other
            // child.
            if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else {
                TreeNode previous = currentNode.left;
                // Check if this left node is a leaf node.
                if (previous.left == null && previous.right == null) {
                    totalSum += previous.val;
                }
                // Find the inorder predecessor for currentNode.
                while (previous.right != null && !previous.right.equals(currentNode)) {
                    previous = previous.right;
                }
                // We've not yet visited the inorder predecessor. This means that we
                // still need to explore currentNode's left subtree. Before doing this,
                // we will put a link back so that we can get back to the right subtree
                // when we need to.
                if (previous.right == null) {
                    previous.right = currentNode;
                    currentNode = currentNode.left;
                }
                // We have already visited the inorder predecessor. This means that we
                // need to remove the link we added, and then move onto the right
                // subtree and explore it.
                else {
                    previous.right = null;
                    currentNode = currentNode.right;
                }
            }
        }
        return totalSum;
    }
}
