package sdeSheet.binaryTree;

public class TreeNode {

  public int data;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  private static int index = -1;

  public static TreeNode buildTree(int[] nodes) {

    index++;

    if (nodes[index] == -1) {
      return null;
    }

    TreeNode newTreeNode = new TreeNode(nodes[index], null, null);
    newTreeNode.left = buildTree(nodes);
    newTreeNode.right = buildTree(nodes);

    return newTreeNode;
  }
}
