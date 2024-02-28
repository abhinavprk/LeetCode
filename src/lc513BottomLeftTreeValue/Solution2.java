package lc513BottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    int maxDistanceFromLeft;
    TreeNode leftMost;

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        sol.findTheBottomLeft(new TreeNode());
    }
    private int findTheBottomLeft(TreeNode node){
        Queue<TreeNode> visited = new LinkedList<>();
        TreeNode current = node;
        visited.add(current);

        while (!visited.isEmpty()){
            current = visited.poll();
            if (current.right != null){
                visited.add(current.right);
            }
            if (current.left != null){
                visited.add(current.left);
            }
        }
        /*
        When the Queue will be empty, the current node will be the left most bottom node.
        We are adding right node at every level first to the Queue(line 21). If we add the left node first,
        we will find the right most bottom node at the end.
         */
        return current.val;
    }
}
