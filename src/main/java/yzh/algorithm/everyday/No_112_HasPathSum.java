package yzh.algorithm.everyday;

import yzh.algorithm.common.TreeNode;

import java.beans.beancontext.BeanContext;
import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @author yongzhenhuang
 */
public class No_112_HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        TreeNode flag = null;
        int count = root.val;
        while (!stack.empty()) {
            temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                if (sum == count) {
                    return true;
                }
                count -= temp.val;
                flag = stack.pop();
            } else {
                if (temp.right != null && temp.right == flag) {
                    count -= temp.val;
                    flag = stack.pop();
                } else {
                    if (temp.left != null && temp.left != flag) {
                        count += temp.left.val;
                        stack.push(temp.left);
                    } else if (temp.right != null) {
                        count += temp.right.val;
                        stack.push(temp.right);
                    } else {
                        count -= temp.val;
                        flag = stack.pop();
                    }
                }
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }
}
