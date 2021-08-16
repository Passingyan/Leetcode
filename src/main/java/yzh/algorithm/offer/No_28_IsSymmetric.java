package yzh.algorithm.offer;

import yzh.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yongzh
 * @date 2021/8/16
 * <p>
 * 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class No_28_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> leftQueue = storeNode(root.left, false);
        Queue<TreeNode> rightQueue = storeNode(root.right, true);
        if (leftQueue.size() != rightQueue.size()) {
            return false;
        }
        TreeNode left, right;
        while (!leftQueue.isEmpty()) {
            left = leftQueue.poll();
            right = rightQueue.poll();

            if (left == null && right == null) {
                continue;
            } else if (left != null && right != null && left.val == right.val) {
                continue;
            }
            return false;
        }
        return true;
    }


    private Queue<TreeNode> storeNode(TreeNode node, boolean reverse) {
        Queue<TreeNode> main = new LinkedList<>();
        Queue<TreeNode> help = new LinkedList<>();
        main.add(node);
        help.add(node);
        TreeNode temp;
        while (!help.isEmpty()) {
            temp = help.poll();
            if (temp == null) continue;
            if (reverse) {
                main.add(temp.right);
                main.add(temp.left);
                help.add(temp.right);
                help.add(temp.left);
            } else {
                main.add(temp.left);
                main.add(temp.right);
                help.add(temp.left);
                help.add(temp.right);
            }
        }
        return main;
    }


    public boolean isSymmetric2(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
