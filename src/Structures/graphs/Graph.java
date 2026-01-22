package Structures.graphs;

import Structures.Nodes.Node;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph<T> {
    List<Node<T>> nodes;
    private Map <Node<T>, List<Node<T>>> mapa;
    public Graph(List<Node<T>> nodes) {
        this.mapa=new HashMap<Node<T>, List<Node<T>>>();
    }
    public Graph() {
    this.mapa = new HashMap<>();
    this.nodes = new ArrayList<>(); // Inicializa también la lista de nodos para evitar NullPointerException
}
    public void insertNode(Node<T> node) {
        Node<T> newNode = new Node<>(node.value);
        this.nodes.add(newNode);
    }

    public void addNode(Node<T> node){
        mapa.putIfAbsent(node, new ArrayList<>());

    }
    public void addEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);

    }

public void addConocido(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
    }
    public void addConocido(T dato1, T dato2) {
        // Aquí es donde ocurre la "magia": envolvemos la Persona en un Node
        Node<T> n1 = new Node<>(dato1);
        Node<T> n2 = new Node<>(dato2);
        
        // Llamamos al método de arriba para reutilizar la lógica
        this.addConocido(n1, n2);
    }
    public void printGraph(){
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
          System.out.print(entry.getKey().value + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor.value + " ");
            }
           
            System.out.println();
        }
    }
    public List<Node<T>> getNeighbors(Node<T> node) {
        return mapa.getOrDefault(node, List.of());
    }

    public void bfs(Node<T> start) {
        Set<Node<T>> visitados=new LinkedHashSet<>();
        Queue<Node<T>> queue=new LinkedList<>();
        visitados.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node<T> current=queue.poll();
            System.out.print(current.value+" ");
            for (Node<T> neighbor : getNeighbors(current)) {
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor);
                    queue.add(neighbor);
                }
            }

        }
    }

    public void dfs(Node<T> start) {
        Set<Node<T>> visitados=new LinkedHashSet<>();
        dfsRecursive(start, visitados);
    }
    private void dfsRecursive(Node<T> start, Set<Node<T>> visitados) {
        visitados.add(start);
        System.out.print(start.value+" ");
        for (Node<T> neighbor : getNeighbors(start)) {
            if (!visitados.contains(neighbor)) {
                dfsRecursive(neighbor, visitados);
            }
        }
    }
    

    

    
}
