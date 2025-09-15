package sdeSheet.binaryTree;

public class SumOfNodes {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println("Sum of the Nodes: " + sumOfNodes(treeNode));
    System.out.println("Sum of the Nodes: " + sumOfNodesAnotherWay(treeNode));
  }

  public static int sumOfNodes(TreeNode root) {

    if (null == root) {
      return 0;
    }

    return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
  }

  public static int sumOfNodesAnotherWay(TreeNode root) {

    if (null == root) {
      return 0;
    }

    int leftSum = sumOfNodesAnotherWay(root.left);
    int rightSum = sumOfNodesAnotherWay(root.right);
    return leftSum + rightSum + root.data;
  }
}
