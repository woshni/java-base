package com.yinc.demo.leetcode;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST98 {


    private TreeNode nodePre;

    /**
     *  中序遍历： 先左后跟在右
     * @param node
     * @return
     */
    public boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!helper(node.left)) {
            return false;
        }
        if (nodePre != null && nodePre.val >= node.val) {
            return false;
        }
        nodePre = node;
        return helper(node.right);
    }

    /**
     *  先右， 在根， 在左
     * @param node
     * @return
     */
    public boolean helper1(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!helper(node.right)) {
            return false;
        }
        if (nodePre != null && nodePre.val >= node.val) {
            return false;
        }
        nodePre = node;
        return helper(node.left);
    }

    public boolean helper2(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return helper2(node.left, min, node.val) && helper2(node.right, node.val, max);
    }



    static class TreeNode {
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
