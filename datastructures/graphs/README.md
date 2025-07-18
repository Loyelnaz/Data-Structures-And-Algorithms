## Graph
* Is a collection of **vertices or nodes** (data and a pointer to next node) that are connected to each other via **edges** to form a network
* The data that can be stored in a node can be an integer, a boolean, a hash map or your own custom objects
* A pair(x,y) is called an **edge**, which indicates that vertex x is connected to vertex y. 
* An edge may contain weight/cost, showing how much cost is required to traverse from vertex x to y.
* Linked list too is a type of graph

### Types of Graphs
#### Directed Graph:
You can traverse only in one direction i.e. if you're at vertex x, you can move from x->y, but not from y->x
#### Undirected Graph:
You can traverse in both the directions. If there's a pair(x,y), you can either traverse from x to y or vice versa

### Terminologies
#### Degree of vertex:
Total number of edges connected to a vertex
* In-degree - number of incoming edges 
* Out-degree - number of outgoing edges

#### Connected Component
A group of nodes that are connected by edges

#### Cyclic Graph
A path in the edge that visits the same node multiple times

### Representation:
#### Adjacency List
* 2D integer array or array of linked list used to store edges between two nodes
* The size of the list is equal to the number of nodes
* Nodes numbered from 0 to n-1
* graph[i] will have all the outgoing edges from the ith node
* Ex: [[1],[2],[0,3],[]]
* We don't need any pre-processing

#### Array of edges
* Nodes numbered from 0 to n-1
* It's an array where graph[i]=[x,y], which indicates that there is an edge from x to y
* Ex: edges = [[0, 1], [1, 2], [2, 0], [2, 3]]
* At every node, we would need to iterate over the entire input to find the neighbors
* Pre-process and store the information in Hash Map so that we can easily access all the neighbors of a given node

Code to build the graph (HashMap):
```
public Map<Integer, List<Integer>> buildGraph(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge: edges) {
        int x = edge[0], y = edge[1];
        if (!graph.containsKey(x)) {
            graph.put(x, new ArrayList<>());
        }
        graph.get(x).add(y);

        // if (!graph.containsKey(y)) {
        //     graph.put(y, new ArrayList<>());
        // }
        // graph.get(y).add(x);

        // uncomment the above lines if the graph is undirected
    }

    return graph;
}
```

#### Adjacency Matrix
* Nodes numbered from 0 to n-1 
* 2D matrix of size n x n
* If graph[i][j] == 1, that means there is an outgoing edge from node i to node j
* Ex: [[0,1,0,0],[0,0,1,0],[1,0,0,1],[0,0,0,0]]
* There are two options:
  * For any given **node**, iterate over graph[node], and if graph[node][i] == 1, then you know that the node **i** is a neighbor.
  * You can pre-process the graph. Build a hash map and then iterate over the entire graph. If graph[i][j] == 1, then put j in the list associated with graph[i].

      ![img.png](img.png)

#### 2D Matrix
* In this case, each square **(row, col)** of the matrix is a node, and the neighbors are **(row - 1, col), (row, col - 1), (row + 1, col), (row, col + 1)** (if in bounds).
* Unlike other input formats, the nodes in these graphs are not numbered **0 until n**. Instead, each element in the matrix represents a node. The edges are determined by the problem description, not the input.

#### Comparison
* If we have to do frequent modification of vertices, then we can use adjacency list
* If we are dealing majorly in edges, adjacency matrix is a better choice
![img_1.png](img_1.png)

#### Traversal Techniques
* [Breadth First Search](BreadthFirstSearch.java)
* [Depth First Search](DepthFirstSearch.java)

#### DFS Problems
* [Number of Provinces](NumberOfProvinces.java)
* [Number of Islands](NumberOfIslands.java)
* [Number of connected components in an undirected graph](ConnectedComponentsInUndirectedGraph.java)
* [Reorder Routes to Make All Paths Lead to the City Zero](ReorderRoutes.java)
* [Check cycle in a graph](CheckCycleInGraph.java)
* [Keys And Rooms](KeysAndRooms.java)
* [Minimum Number of Vertices to Reach All Nodes](MinVerticesToReachAllNodes.java)
* [Find if path exists in graph](PathExists.java)
* [Max Area of Island](MaxAreaOfIsland.java)
* [Reachable Node With Restrictions](ReachableNodeWithRestrictions.java)

#### Breadth First Search
* While solving graph problems, it doesn't matter if we use DFS or BFS for traversal in most of them. People go with DFS as it is cleaner and can be done recursively too
* There are a few problems, where BFS is a clear winner. For example, in finding the **shortest path** or **fewest operations**
* The key idea behind BFS on graphs - every time you visit a node, you must have reached it in the minimum steps possible from wherever you started your BFS.
* DFS was implemented using a Stack, and BFS will be using a Queue (Iteratively)

#### BFS Problems
* [Shortest Path in Binary Matrix](ShortestPathInBinaryMatrix.java)
* [All Nodes Distance K in Binary Tree](AllNodesDistanceKInBinaryTree.java)
* [01 Matrix](ZeroOneMatrix.java)
* [Shortest Path in a Grid with Obstacle Elimination](ShortestPathWithObstaclesElimination.java)
* [Snakes And Ladders](SnakeAndLadder.java)

#### Implicit Graphs
* In the above problems so far, the input in some or the other way indicated that the problem was related to graph
* As graph is an abstract collection of elements (nodes) connected by abstract relationships (edges).
* If a problem involves transitioning between states, then try to think about if the states can be nodes and the transition criteria can be edges

#### Problems
* [Open the lock](OpenTheLock.java)
* [Minimum Genetic Mutation](MinimumGeneticMutation.java)
* [Jump Game III](JumpGameThree.java)
* [Word Ladder](WordLadder.java)