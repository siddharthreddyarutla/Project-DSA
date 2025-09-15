package sdeSheet.binaryTree;

public class PostOrderTraversal {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println("Post order traversal:");
    postorderTraversal(treeNode);
  }

  public static void postorderTraversal(TreeNode root) {

    if (null == root) {
      return;
    }

    postorderTraversal(root.left);
    postorderTraversal(root.right);
    System.out.print(root.data + " ");
  }
}
