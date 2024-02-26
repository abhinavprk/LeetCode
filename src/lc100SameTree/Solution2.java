package lc100SameTree;

public class Solution2 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        
        TreeNode p = new TreeNode(1, left,right);
        TreeNode q = new TreeNode(1, left,right);

        System.out.println(isSameTree(p,q));
        
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame;
        if ((p == null) && (q == null)) {
            isSame = true;
        } else if ((p == null) || (q == null)) {
            isSame = false;
        } else if ((p.val != q.val)) {
            isSame = false;
        } else {
            isSame = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return isSame;
    }
}
