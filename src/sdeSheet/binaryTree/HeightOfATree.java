package sdeSheet.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfATree {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, 5, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println(
        "Height of a binary tree: " + heightOfABinaryTreeUsingLevelOrderTraversal(treeNode));
    System.out.println("Height of a binary tree: " + heightOfATreeRecursive(treeNode));
  }

  // Can be found using level order traversal for height
  public static int heightOfABinaryTreeUsingLevelOrderTraversal(TreeNode root) {

    int height = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);

    while (!queue.isEmpty()) {

      TreeNode currentNode = queue.poll();

      if (null == currentNode) {
        height++;

        if (queue.isEmpty()) {
          break;
        } else {
          queue.offer(null);
        }
      } else {

        if (null != currentNode.left) {
          queue.offer(currentNode.left);
        }

        if (null != currentNode.right) {
          queue.offer(currentNode.right);
        }
      }
    }
    return height;
  }

  public static int heightOfATreeRecursive(TreeNode root) {

    if (null == root) {
      return 0;
    }

    int leftSubTreeHeight = heightOfATreeRecursive(root.left);
    int rightSubTreeHeight = heightOfATreeRecursive(root.right);

    return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
  }
}
