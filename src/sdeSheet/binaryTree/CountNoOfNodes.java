package sdeSheet.binaryTree;

public class CountNoOfNodes {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode root = TreeNode.buildTree(nodes);

    System.out.println("No of nodes: " + countOfNodes(root));
    System.out.println("No of nodes: " + countOfNodesAnotherWay(root));
  }

  public static int countOfNodes(TreeNode root) {

    // If root is null then 0
    if (null == root) {
      return 0;
    }

    return countOfNodes(root.left) + countOfNodes(root.right) + 1;
  }

  public static int countOfNodesAnotherWay(TreeNode root) {

    // If root is null then 0
    if (null == root) {
      return 0;
    }

    int leftCount = countOfNodesAnotherWay(root.left);
    int rightCount = countOfNodesAnotherWay(root.right);
    return leftCount + rightCount + 1;
  }
}
