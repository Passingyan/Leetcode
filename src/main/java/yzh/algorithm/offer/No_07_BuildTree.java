package yzh.algorithm.offer;

import yzh.algorithm.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 解题思想：
 * 递归法，通过前序的顺序，找子树根节点，然后通过中序，找到根节点的左子树、右子树，依次递归下去。
 * 如示例：  前序 3,9,20,15,7   中序  9,3,15,20,7
 * 则初始确定子树根节点为3  左子树的中序范围：9   右子树的范围：15 20 7
 * <p>
 * 递归， 左子树就一个节点，结束返回；
 * 递归，右子树有三个节点，通过前序可知， 15 20 7在前序中 20最早出现，则20为右子树的根节点。
 * 继续递归，直到子树只剩一个节点，即为叶子节点。
 * <p>
 * 时间复杂度
 */
public class No_07_BuildTree {

    private Map<Integer, Integer> preorderMap = new HashMap<>();
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
            inorderMap.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return recursiveBuildTree(inorderMap.get(preorder[0]), 0, inorder.length - 1);
    }

    public TreeNode recursiveBuildTree(int rootIndex, int begin, int end) {
        TreeNode treeNode = new TreeNode(inorder[rootIndex]);
        if (begin == end) return treeNode;
        if (rootIndex == begin) {
            treeNode.left = null;
        } else {
            int leftRootIndex = preorderMap.size();
            for (int i = begin; i < rootIndex; i++) {
                leftRootIndex = Math.min(leftRootIndex, preorderMap.get(inorder[i]));
            }
            leftRootIndex = inorderMap.get(preorder[leftRootIndex]);
            treeNode.left = recursiveBuildTree(leftRootIndex, begin, rootIndex - 1);
        }
        if (rootIndex == end) {
            treeNode.right = null;
        } else {
            int rightRootIndex = preorderMap.size();
            for (int i = rootIndex + 1; i <= end; i++) {
                rightRootIndex = Math.min(rightRootIndex, preorderMap.get(inorder[i]));
            }
            rightRootIndex = inorderMap.get(preorder[rightRootIndex]);
            treeNode.right = recursiveBuildTree(rightRootIndex, rootIndex + 1, end);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new No_07_BuildTree().buildTree(preorder, inorder);
    }
}
