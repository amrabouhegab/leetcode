package src;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        List<Integer> integers = inorderTraversal(treeNode);
        integers.forEach(System.out::println);
        System.out.println("=============================================================");
        TreeNode treeNode1 = new TreeNode(2, new TreeNode(3, new TreeNode(1, null, null), null), null);
        List<Integer> integers1 = inorderTraversal(treeNode1);
        integers1.forEach(System.out::println);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            inorder(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            inorder(node.right, result);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

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
