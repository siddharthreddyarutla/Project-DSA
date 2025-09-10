package sdeSheet.binaryTree;

public class BinaryTreeTraversal {

  public static class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }


  public static class BinaryTree {

    private static int index = -1;

    public static Node buildTree(int[] nodes) {

      index++;

      if (nodes[index] == -1) {
        return null;
      }

      Node newNode = new Node(nodes[index], null, null);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }

    /**
     * Complexity is O(N)
     *
     * @param root
     */
    public void preOrderTraversal(Node root) {
      if (null == root) {
//        System.out.print(-1 + " ");
        return;
      }
      System.out.print(root.data + " ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
    }

    public void inorderTraversal(Node root) {

      if (null == root) {
//        System.out.print(-1 + " ");
        return;
      }

      inorderTraversal(root.left);
      System.out.print(root.data + " ");
      inorderTraversal(root.right);
    }

    public void postorderTraversal(Node root) {

      if (null == root) {
        return;
      }

      postorderTraversal(root.left);
      postorderTraversal(root.right);
      System.out.print(root.data + " ");
    }
  }

  public static void main(String[] args) {
    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

    BinaryTree binaryTree = new BinaryTree();
    Node rootNode = binaryTree.buildTree(nodes);
    System.out.println("Root node data: " + rootNode.data);

    System.out.println("Pre order traversal:");
    binaryTree.preOrderTraversal(rootNode);

    System.out.println();
    System.out.println("In order traversal:");
    binaryTree.inorderTraversal(rootNode);

    System.out.println();
    System.out.println("Post order traversal:");
    binaryTree.postorderTraversal(rootNode);
  }
}
