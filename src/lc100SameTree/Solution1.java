package lc100SameTree;

public class Solution1 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        
        TreeNode p = new TreeNode(1, left,right);
        TreeNode q = new TreeNode(1, left,right);

        System.out.println(isSameTree(p,q));
        
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null) && (q==null)){
            return true;
        }
        if((p == null) || (q==null)){
            return false;
        }
        if((p.val != q.val)){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
