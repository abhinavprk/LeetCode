package lc513BottomLeftTreeValue;

import com.sun.source.tree.Tree;
import lc100SameTree.TreeNode;

public class Solution1 {
    int maxDistanceFromLeft;
    TreeNode leftMost;

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        sol.findTheBottomLeft(new TreeNode(), 0);
    }
    private void findTheBottomLeft(TreeNode node, int distance){
        if(node == null){
            return;
        }
        //At every level distance / depth increases by 1
        distance+= 1;
        if(distance > maxDistanceFromLeft){
            maxDistanceFromLeft = distance;
            leftMost = node;
        }
        /*
        If we find left node first, even if there is a right node at the same level, the left node
        is evaluated first and since the depth of the right node is same as the left node it will
        not replace the left node as leftMost. distance will be equal to the maxDistanceFromLeft
         */
        findTheBottomLeft(node.left, distance);
        findTheBottomLeft(node.right, distance);
    }
}
