package yzh.algorithm.offer;

import yzh.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongzh
 * @date 2021/8/15
 * <p>
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class No_26_IsSubStructure {

    /**
     * 思路：
     * 先从A中找出是否有节点是与B相同的。
     * 1、存在相同的，则再同步遍历。
     * 2、不存在相同的，则返回 false。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        }
        List<TreeNode> sameList = new ArrayList<>();
        searchSameNode(A, B, sameList);
        if (sameList.size() == 0) {
            return false;
        }
        for (TreeNode same : sameList) {
            if (isSame(same, B)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 优化，直接在A树上，递归调用+判断即可.
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure2(A.left, B) || isSubStructure2(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    /**
     * 递归遍历，从A中找与B同值的节点.
     */
    private void searchSameNode(TreeNode A, TreeNode B,
                                List<TreeNode> sameList) {
        if (A.val == B.val) {
            sameList.add(A);
        }
        if (A.left != null) {
            searchSameNode(A.left, B, sameList);
        }
        if (A.right != null) {
            searchSameNode(A.right, B, sameList);
        }
    }

    /**
     * 递归同步遍历，每一个子树都相同，则为相同.
     */
    private boolean isSame(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }

        return (B.left == null || isSame(A.left, B.left))
                && (B.right == null || isSame(A.right, B.right));
    }

}
