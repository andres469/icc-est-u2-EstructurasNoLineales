package Structures.graphs;

import Structures.Nodes.Node;

public interface  PathFinder<T> {
    PathResult<T> findPath(Graph<T> graph, Node<T> start, Node<T> end);
    
}
