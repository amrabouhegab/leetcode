package src;

public class SameTree {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode tree2 = new TreeNode(1, new TreeNode(2, null, null), null);
        System.out.println(isSameTree(tree1, tree2));
        System.out.println("=======================================================================");
        TreeNode tree3 = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode tree4 = new TreeNode(1, null, new TreeNode(2, null, null));
        System.out.println(isSameTree(tree3, tree4));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ( (p == null || q == null) || (p.val != q.val) ) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
