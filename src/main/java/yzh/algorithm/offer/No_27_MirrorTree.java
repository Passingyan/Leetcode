package yzh.algorithm.offer;

import yzh.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yongzh
 * @date 2021/8/16
 * <p>
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class No_27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> mainQueue = new LinkedList<>();
        Queue<TreeNode> helpQueue = new LinkedList<>();
        TreeNode newRoot = new TreeNode(root.val);
        mainQueue.add(root);
        helpQueue.add(newRoot);

        TreeNode temp, tempNew;
        while (!mainQueue.isEmpty()) {
            temp = mainQueue.poll();
            tempNew = helpQueue.poll();
            if (temp.left != null) {
                mainQueue.add(temp.left);
                tempNew.right = new TreeNode(temp.left.val);
                helpQueue.add(tempNew.right);
            }
            if (temp.right != null) {
                mainQueue.add(temp.right);
                tempNew.left = new TreeNode(temp.right.val);
                helpQueue.add(tempNew.left);
            }
        }
        return newRoot;
    }
}
