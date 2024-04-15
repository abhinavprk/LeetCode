package lc129SumRootToLeafNumbers;

import lc100SameTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    private static boolean isLeaf(TreeNode node){
        return (node != null) && (node.left == null) && (node.right == null);
    }
    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, StringBuilder> values = new HashMap<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            StringBuilder str = new StringBuilder(values.getOrDefault(node, new StringBuilder()));
            str.append(node.val);
            StringBuilder prefix = new StringBuilder(str);
            if(isLeaf(node)){
                sum = sum + Integer.parseInt(str.toString());
            }
            if(node.left !=null ){
                stack.push(node.left);
                values.put(node.left, prefix);
                str.append(node.left.val);
            }
            if(node.right !=null ){
                values.put(node.right, prefix);
                stack.push(node.right);
            }
        }
        return sum;
    }

}
