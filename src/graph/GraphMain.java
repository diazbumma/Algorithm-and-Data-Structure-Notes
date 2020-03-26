package graph;

import java.util.*;

public class GraphMain {

    static class Graph {

        int V;
        HashMap<Character, LinkedList<Character>> adjList;

        Graph() {
            this.V = 0;
            this.adjList = new HashMap<>();
        }

        void addNode(Character v) {
            adjList.put(v, new LinkedList<>());
            ++V;
        }

        void addEdge(Character s, Character t) {
            adjList.get(s).add(t);
            adjList.get(t).add(s);
        }

        void bfs(Character s) {
            Queue<Character> frontier = new LinkedList<>();
            ArrayList<Character> visited = new ArrayList<>();

            frontier.add(s);
            visited.add(s);

            System.out.print("Breadth First Search: ");

            while (!frontier.isEmpty()) {
                int size = frontier.size();

                for (int i = 0; i < size; i++) {
                    Character u = frontier.poll();
                    LinkedList<Character> adj = adjList.get(u);

                    System.out.print(u + " ");

                    for (Character v: adj) {
                        if (!visited.contains(v)) {
                            frontier.add(v);
                            visited.add(v);
                        }
                    }
                }
            }

            System.out.println("\n");
        }
    }

    static void printGraph(Graph graph) {
        for(Map.Entry<Character, LinkedList<Character>> adj: graph.adjList.entrySet()) {
            System.out.println("Adjacency list of node " + adj.getKey());
            System.out.print("head");

            for(Character child : adj.getValue()){
                System.out.print(" -> "+ child);
            }

            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // add vertices/nodes
        for (char i = 'a'; i <= 'h'; i++) {
            graph.addNode(i);
        }

        graph.addEdge('a', 'e');
        graph.addEdge('a', 'b');
        graph.addEdge('b', 'f');
        graph.addEdge('c', 'f');
        graph.addEdge('f', 'g');
        graph.addEdge('c', 'g');
        graph.addEdge('c', 'd');
        graph.addEdge('d', 'g');
        graph.addEdge('g', 'h');
        graph.addEdge('d', 'h');

        //printGraph(graph);

        //breadth first search from node b
        graph.bfs('b');
    }
}
