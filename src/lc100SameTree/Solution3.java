package lc100SameTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

public class Solution3 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        
        TreeNode p = new TreeNode(1, left,right);
        TreeNode q = new TreeNode(1, left,right);

        System.out.println(isSameTree(p,q));
        
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if ((a == null) && (b == null)) {
               continue;
            }
            if ((a == null) || (b == null)) {
                return false;
            }
            if ((a.val != b.val)) {
               return  false;
            }
            queue.add(a.left);
            queue.add(b.left);
            queue.add(a.right);
            queue.add(b.right);
        }
        return true;
    }
}
