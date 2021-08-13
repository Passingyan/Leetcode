package yzh.algorithm.offer;

import yzh.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yongzh
 * @date 2021/8/13
 * <p>
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/mian-shi-ti-32-ii-cong-shang-dao-xia-da-yin-er-c-5/
 */
public class No_32_LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> helpQueue;
        queue.add(root);
        TreeNode temp;
        List<Integer> one;
        while (!queue.isEmpty()) {
            one = new ArrayList<>();
            helpQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                temp = queue.poll();
                one.add(temp.val);
                if (temp.left != null) {
                    helpQueue.add(temp.left);
                }

                if (temp.right != null) {
                    helpQueue.add(temp.right);
                }
            }
            list.add(one);
            queue = helpQueue;
        }
        return list;

    }


}
