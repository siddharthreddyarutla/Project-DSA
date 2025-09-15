package sdeSheet.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {

  public static void main(String[] args) {

    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    TreeNode treeNode = TreeNode.buildTree(nodes);

    System.out.println("Level order traversal:");
    levelOrder(treeNode);
  }


  public static void levelOrder(TreeNode root) {

    if (null == root) {
      return;
    }
      /*
        1
       /  \
      2    3
     / \    \
    4   5    6
      */

      /* using queue as we are pushing each sub tree and polling to print in level order
       1. Add level 0 root queue is not empty
       2. Poll you'll get root and queue is empty and print root data
       3. print data 1
       4. As left and right are not empty add both sub trees into queue left -> 2,4,5 and right
       -> 3,6 and queue size is 2
       5. As level 0 is over Next will be null so new line
       6. Then level 1 left sub tree root will poll and queue has right subtree only as size 1
       7. print 2
       8. left -> 4 and right -> 5 into queue now queue size is 3
       6. Then level 0 right sub tree root will poll queue has 2 size with level 1 left sub trees
        left and right sub tree
       7. Will print 3
       8. left is not there right is there will add right sub tree and queue size is 3 again
       9. As level 1 is over null new line
       10. Now poll level 2 root which is level 1's left sub tree, queue has level 1's left sub
       tree's right and level 1 right sub tree's right
       11. Print 4
       12. further no left and no right for root 4
       13. Poll right and queue size is 1 as level 1's right sub tree
       14. print 5
       15. Further no left and right
       16. Poll last element in queue and that is level 1 right sub tree
       17. Print 6
       18. No left and right sub tree and queue is empty it is return
          */
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);

    while (!queue.isEmpty()) {

      TreeNode currentNode = queue.poll();
      if (null == currentNode) {
        System.out.println();
        if (queue.isEmpty()) {
          break;
        } else {
          queue.offer(null);
        }
      } else {
        System.out.print(currentNode.data + " ");
        if (null != currentNode.left) {
          queue.add(currentNode.left);
        }
        if (null != currentNode.right) {
          queue.add(currentNode.right);
        }
      }
    }
  }
}
