# Graph

- It is a network of nodes
- It doesn't have any hierarchy like trees ex: parent, Left child and right child etc..


### Edge

- connection between any 2 nodes is an edge
- if single node is vertex and multiple nodes are called as vertices

Use cases:

- It can used in google maps as there can be many ways to reach destination from sooure
- facebook (Social network connections) , our friend A is connected with B and C and C is connected with D and D is connected with A

![img.png](../images/imgGraph1.png)


## Types of graphs

1. Directional
2. Un-directional

### Direction

1. There will be a direction for the edge

ex: 1 -----> 2
    1 <----- 1


### un directional

1. There will be no directions

Ex: 1 ----- 2


## Weighted graphs

- Value associated with the edges

        10
ex: 1 ----- 2

1. reaching from 1 to 2 distance can be 10
2. It can be negative and positive weight as well

Note:

- with this Types of graphs are

1. Directional weighted
2. Directional un-weighted
3. Un-directional weighted
4. Un-directional un-weighted
5. Un connected graphs

![img.png](../images/imgGraph2.png)

![img.png](../images/imgGraph3.png)


## How to Build graphs

### Adjacency list

1. Storing each vertex's edges/neighbours in a list

V - vertex,
E - Edges

![img.png](../images/imgGraph4.png)


Reference code at

> sdeSheet.graph.graph


## Breadth first search

- In BFS, we traverse to the immediate neighbours first.
- As like tree there will no certain root node to traverse 
- So there is no fixed point in the graph we can start from any vertex
- Immediate neighbours -> mark as visited

> sdeSheet.graph.BFSofGraph

## Depth first search

- keep going to 1st unvisited neighbour

![img.png](../images/imgGraph6.png)