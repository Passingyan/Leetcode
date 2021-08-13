package yzh.algorithm.offer;

import yzh.algorithm.common.TreeNode;

import java.util.*;

/**
 * @author yongzh
 * @date 2021/8/13
 * <p>
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class No_32_LevelOrder3 {


    /**
     * 两个队列，一个做遍历队列，一个辅助队列，保证遍历永远是头出，
     * 则需要在子节点插入辅助队列时，保证有序，可以使用左右颠倒的头插到辅助队列中。
     * <p>
     * 简单理解：
     * 第一层，直接遍历，子节点是右左，则可以用头插法的，先头插左，后头插右，保证下层是先出右后出左.
     * 第二层，直接遍历，出来的第一个节点是第二层最右节点，它的下一层是从左到右，则可以先头插右节点，再头插左节点，保证下层是先出左后出右.
     * 第三层，直接遍历，出来的第一个节点是第三层的最左节点，它的下一层是从右到左，则可以先头插左节点，再头插右节点，保证下层是先出右后出左.
     * ......以此类推
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> helpDueue;
        deque.add(root);
        TreeNode temp;
        List<Integer> one;
        int level = 0;
        while (!deque.isEmpty()) {
            one = new ArrayList<>();
            helpDueue = new LinkedList<>();
            while (!deque.isEmpty()) {
                temp = deque.poll();
                one.add(temp.val);
                if (level % 2 == 0) {
                    if (temp.left != null) {
                        helpDueue.addFirst(temp.left);
                    }
                    if (temp.right != null) {
                        helpDueue.addFirst(temp.right);
                    }
                } else {
                    if (temp.right != null) {
                        helpDueue.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        helpDueue.addFirst(temp.left);
                    }
                }
            }
            level++;
            list.add(one);
            deque = helpDueue;
        }
        return list;
    }


}
