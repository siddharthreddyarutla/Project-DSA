package neetCode_150.tree;

import sdeSheet.binaryTree.TreeNode;

public class InvertBinaryTree_226 {

  /**
   * Input: root = [4,2,7,1,3,6,9]
   * Output: [4,7,2,9,6,3,1]
   * Example 2:
   * <p>
   * <p>
   * Input: root = [2,1,3]
   * Output: [2,3,1]
   * Example 3:
   * <p>
   * Input: root = []
   * Output: []
   */

  public static void main(String[] args) {

  }

  public TreeNode invertTree(TreeNode root) {
    invert(root);
    return root;
  }

  public void invert(TreeNode root) {
    if (root == null) {
      return;
    }

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);
  }
}
