import Structures.Nodes.Node;
import Structures.graphs.Graph;
import Structures.graphs.PathFinder;
import Structures.graphs.PathResult;
import Structures.graphs.implementations.BFSPathFinder;
import Structures.graphs.implementations.DFSPathFinder; // 🔥 IMPORTAR DFS
import Structures.trees.IntTree;
import Structures.trees.tree;
import models.Persona;

public class Main {

    public static void main(String[] args) {

        runGraph();              
        runGraphRecorrido();     // 🔥 BFS + DFS

        System.out.println("\n=== Arbol de enteros ===");
        IntTree intTree = new IntTree();
        intTree.insert(10);
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(15);

        System.out.println("\nRecorrido PreOrder:");
        intTree.preOrder();

        System.out.println("\nRecorrido InOrder:");
        intTree.inOrder();

        System.out.println("\nRecorrido PostOrder:");
        intTree.postOrder();

        System.out.println("----------------------------");

        System.out.println("\n=== Árbol de personas (ordenado por edad) ===");
        tree<Persona> personaTree = new tree<>();
        personaTree.insert(new Persona("Ana", 25));
        personaTree.insert(new Persona("Luis", 20));
        personaTree.insert(new Persona("Carlos", 30));
        personaTree.insert(new Persona("María", 22));

        personaTree.inOrder();

        Persona findPerson = personaTree.searchByAge(23);
        if (findPerson != null) {
            System.out.println("Persona encontrada: " + findPerson);
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    // ===================== GRAFO SIMPLE =====================
    public static void runGraph() {

        System.out.println("=== Grafo simple ===");

        Graph<String> graph = new Graph<>();
        Node<String> nA = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");

        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);

        graph.printGraph();
    }

    // ===================== BFS + DFS =====================
    private static void runGraphRecorrido() {

        System.out.println("\n=== Grafo de Personas ===");

        Graph<Persona> grafo = new Graph<>();

        Persona pC23 = new Persona("Carlos", 23);
        Persona pL18 = new Persona("Luis", 18);
        Persona pA23 = new Persona("Andres", 23);
        Persona pA30 = new Persona("Ana", 30);
        Persona pJ25 = new Persona("Juan", 25);
        Persona pAn20 = new Persona("Ana", 20);
        Persona pM10 = new Persona("Mateo", 10);
        Persona pJ10 = new Persona("Julio", 10);

        Node<Persona> nC23 = new Node<>(pC23);
        Node<Persona> nL18 = new Node<>(pL18);
        Node<Persona> nA23 = new Node<>(pA23);
        Node<Persona> nA30 = new Node<>(pA30);
        Node<Persona> nJ25 = new Node<>(pJ25);
        Node<Persona> nAn20 = new Node<>(pAn20);
        Node<Persona> nM10 = new Node<>(pM10);
        Node<Persona> nJ10 = new Node<>(pJ10);

        grafo.addEdge(nC23, nA30);
        grafo.addConocido(nC23, nL18);
        grafo.addConocido(nC23, nA23);
        grafo.addConocido(nL18, nJ25);
        grafo.addEdge(nL18, nA23);
        grafo.addConocido(nAn20, nA30);
        grafo.addEdge(nA30, nM10);
        grafo.addEdge(nM10, nJ10);

        grafo.printGraph();

        // 🔥 BFS
        PathFinder<Persona> bfs = new BFSPathFinder<>();
        PathResult<Persona> bfsResult = bfs.findPath(grafo, nC23, nJ10);

        System.out.println("\n--- BFS ---");
        System.out.println("Nodos visitados:");
        bfsResult.getVisitados().forEach(System.out::println);
        System.out.println();
        System.out.println("Camino encontrado:");
        bfsResult.getPath().forEach(System.out::println);

        // 🔥 DFS
        PathFinder<Persona> dfs = new DFSPathFinder<>();
        PathResult<Persona> dfsResult = dfs.findPath(grafo, nC23, nJ10);

        System.out.println("\n--- DFS ---");
        System.out.println("Nodos visitados:");
        dfsResult.getVisitados().forEach(System.out::println);
        System.out.println();
        System.out.println("Camino encontrado:");
        dfsResult.getPath().forEach(System.out::println);
    }
}
