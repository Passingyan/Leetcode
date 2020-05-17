package yzh.algorithm.toutiao;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yongzh
 * @date 2020/5/17
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> ltr = new ArrayDeque<>();
        ArrayDeque<TreeNode> rtl = new ArrayDeque<>();
        boolean flag = true;
        ltr.add(root);

        List<Integer> temp;
        TreeNode node;
        while (!(ltr.size() == 0 && rtl.size() == 0)) {
            temp = new ArrayList<>();
            if (flag) {
                flag = false;
                while (ltr.size() > 0) {
                    node = ltr.remove();
                    temp.add(node.val);
                    if (node.left != null) rtl.addLast(node.left);
                    if (node.right != null) rtl.addLast(node.right);
                }
            } else {
                flag = true;
                while (rtl.size() > 0) {
                    node = rtl.removeLast();
                    temp.add(node.val);
                    if (node.right != null) ltr.addFirst(node.right);
                    if (node.left != null) ltr.addFirst(node.left);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
