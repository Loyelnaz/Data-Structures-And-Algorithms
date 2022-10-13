#Graph
* Is a collection of nodes (data and a pointer to next node)
* The data can be an integer, a boolean, a hash map or your own custom objects
* Linked list too is a type of graph
* The nodes of a graph are also called <b>vertices</b>, and the pointers that connect them are called <b>edges</b>.

####Directed Edges:
You can traverse only in one direction i.e. if you're at node A, you can move from A->B, but not from B->A</br>
####Undirected Edges
You can traverse in both the directions.
####Connected Component
A group of nodes that are connected by edges
####Cyclic Graph
A path in the edge that visits the same node multiple times

The number of edges that can be used to reach the node is the node's <b>indegree</b>. The number of edges that can be used to exit the node is the node's <b>outdegree</b>. Nodes that are connected by an edge are called <b>neighbors</b>.

###Different ways graphs can be declared:
####Adjacency List
* 2D integer array
* Nodes numbered from 0 to n-1
* graph[i] will have all the outgoing edges from the ith node
* Ex: [[1],[2],[0,3],[]]

####Array of edges
* Nodes numbered from 0 to n-1
* It's an array where graph[i]=[x,y], which indicates that there is an edge from x to y
* Ex: edges = [[0, 1], [1, 2], [2, 0], [2, 3]]

####Adjacency Matrix
* Nodes numbered from 0 to n-1 
* 2D matrix of size n x n
* If graph[i][j] == 1, that means there is an outgoing edge from node i to node j
* Ex: [[0,1,0,0],[0,0,1,0],[1,0,0,1],[0,0,0,0]]