package sdeSheet.binaryTree;

public class DiameterOfATree {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println("Diameter of a tree: " + diameterOfATree(treeNode));
    System.out.println("Diameter of a tree: " + diameterOfATreeOptimized(treeNode).diameter);
  }

  /**
   * This is O(n2) finding diameter by iterating once and for height again we are doing
   *
   * @param root
   *
   * @return
   */
  public static int diameterOfATree(TreeNode root) {

    if (null == root) {
      return 0;
    }

    int diameterOfLST = diameterOfATree(root.left);
    int diameterOfRST = diameterOfATree(root.right);
    int diameterIncludingRoot =
        HeightOfATree.heightOfATreeRecursive(root.left) + HeightOfATree.heightOfATreeRecursive(
            root.right) + 1;

    int maxOfST = Math.max(diameterOfLST, diameterOfRST);
    return Math.max(maxOfST, diameterIncludingRoot);
  }


  public static TreeInfo diameterOfATreeOptimized(TreeNode root) {

    if (null == root) {
      return new TreeInfo(0, 0);
    }

    TreeInfo leftInfo = diameterOfATreeOptimized(root.left);
    TreeInfo rightInfo = diameterOfATreeOptimized(root.right);

    int diameterOfLST = leftInfo.diameter;
    int diameterOfRST = rightInfo.diameter;
    int diameterIncludingRoot = leftInfo.height + rightInfo.height + 1;

    int diameterOfMaxST = Math.max(diameterOfLST, diameterOfRST);
    int actualDiameter = Math.max(diameterOfMaxST, diameterIncludingRoot);

    int actualHeight = Math.max(leftInfo.height, rightInfo.height) + 1;

    return new TreeInfo(actualHeight, actualDiameter);
  }

  public static class TreeInfo {

    int height;
    int diameter;

    public TreeInfo(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }
  }
}
