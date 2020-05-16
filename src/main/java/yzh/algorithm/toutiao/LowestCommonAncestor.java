package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/16
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p, q);
    }

    private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.equals(p) || root.equals(q)) return root;

        TreeNode leftResult = null;
        TreeNode rightResult = null;
        if (root.left != null) {
            leftResult = findAncestor(root.left, p, q);
        }

        if (root.right != null) {
            rightResult = findAncestor(root.right, p, q);
        }

        if (leftResult != null && rightResult != null) {
            return root;
        } else if (leftResult == null && rightResult == null) {
            return null;
        } else {
            return leftResult != null ? leftResult : rightResult;
        }
    }
}
