package sdeSheet.binaryTree;

public class InOrderTraversal {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println("In order traversal:");
    inorderTraversal(treeNode);
  }

  public static void inorderTraversal(TreeNode root) {

    if (null == root) {
      //        System.out.print(-1 + " ");
      return;
    }

    inorderTraversal(root.left);
    System.out.print(root.data + " ");
    inorderTraversal(root.right);
  }
}
