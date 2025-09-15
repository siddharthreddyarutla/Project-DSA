package sdeSheet.binaryTree;

public class PreOrderTraversal {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println("Pre order traversal:");
    preOrderTraversal(treeNode);
  }

  public static void preOrderTraversal(TreeNode root) {
    if (null == root) {
      //        System.out.print(-1 + " ");
      return;
    }
    System.out.print(root.data + " ");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }
}
