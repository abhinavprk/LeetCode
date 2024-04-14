package lc404SumOfLeftLeaves;

import lc100SameTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {

    public static void main(String[] args) {

    }

    private static boolean isLeaf(TreeNode node){
        return (node != null) && (node.left == null) && (node.right == null);
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        int total = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        if (root != null) {
            while (!stack.isEmpty()){
                TreeNode subNode = stack.pop();
                if(isLeaf(subNode.left)) {
                  total = total + subNode.left.val;
                } else if(subNode.left != null){
                    stack.push(subNode.left);
                }
                if(subNode.right != null ){
                    stack.push(subNode.right);
                }

            }
        }
        return total;
    }
}
