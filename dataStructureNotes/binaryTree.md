# Binary tree

- Tree is a hierarchical data structure (arrays, LL are linear data structure)
- Tree data structure resembles same as real tree but in a reversed way


![img.png](../images/treeImage.png)


- Binary tree has at max 2 nodes means 2 children to a parent

![img.png](../images/imgTree1.png)


- Level and depth of a binary tree

![img.png](../images/imgTree2.png)

- Sub tree

![img.png](../images/imgTree3.png)


## Binary tree Traversal

![img.png](../images/imgTree4.png)

Reference code at

> sdeSheet.binaryTree


## Preorder traversal

![img.png](../images/imgTree5.png)

> sdeSheet.binaryTree.PreOrderTraversal

## Inorder traversal

![img.png](../images/imgTree6.png)

> sdeSheet.binaryTree.InOrderTraversal


## PostOrder traversal

![img.png](../images/imgTree7.png)

> sdeSheet.binaryTree.PostOrderTraversal

## Level order traversal

![img.png](../images/imgTree8.png)

> sdeSheet.binaryTree.levelOrderTraversal


## Count of Nodes

> Count = X + Y + 1;

X - left sub tree nodes count
Y - Right sub tree nodes count
1 for the parent

![img.png](../images/imgTree9.png)

> sdeSheet.binaryTree.CountNoOfNodes


## Sum of Nodes

![img.png](../images/imgTree10.png)

> sdeSheet.binaryTree.SumOfNodes


## Height of tree

![img.png](../images/imgTree11.png)

> sdeSheet.binaryTree.HeightOfATree


## Diameter of a tree

![img.png](../images/imgTree12.png)

1. Finding diameter by calculating diameter of left subtree and right sub tree
2. Take max of left and right sub tree diamter and to calculate with the root then need to find the height of a left and right sub tree + 1

> Diameter = Max(Diameter(LST), Diameter(RST), (Height(LST) + Height(RST) + 1))