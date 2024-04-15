package lc129SumRootToLeafNumbers;

import lc100SameTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    static int rootToLeaf = 0;
    private static int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;

    }

    private static void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = currNumber * 10 + r.val;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber) ;
        }
    }

}
