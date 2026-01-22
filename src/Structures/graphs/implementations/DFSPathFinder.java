package Structures.graphs.implementations;

import Structures.Nodes.Node;
import Structures.graphs.Graph;
import Structures.graphs.PathFinder;
import Structures.graphs.PathResult;
import java.util.*;

public class DFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> findPath(Graph<T> graph, Node<T> start, Node<T> end) {

        Set<Node<T>> visited = new HashSet<>();
        List<Node<T>> visitados = new ArrayList<>();
        Map<Node<T>, Node<T>> parent = new HashMap<>();

        boolean found = dfs(graph, start, end, visited, visitados, parent);

        if (found) {
            return new PathResult<>(visitados, buildPath(parent, end));
        }

        return new PathResult<>(visitados, new ArrayList<>());
    }

    private boolean dfs(Graph<T> graph,
                        Node<T> current,
                        Node<T> end,
                        Set<Node<T>> visited,
                        List<Node<T>> visitados,
                        Map<Node<T>, Node<T>> parent) {

        visited.add(current);
        visitados.add(current);

        if (current.equals(end)) {
            return true;
        }

        for (Node<T> neighbor : graph.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, current);
                if (dfs(graph, neighbor, end, visited, visitados, parent)) {
                    return true; // ya encontró el destino
                }
            }
        }
        return false;
    }

    private List<Node<T>> buildPath(Map<Node<T>, Node<T>> parent, Node<T> end) {

        List<Node<T>> path = new ArrayList<>();

        for (Node<T> at = end; at != null; at = parent.get(at)) {
            path.add(0, at);
        }

        return path;
    }
}
