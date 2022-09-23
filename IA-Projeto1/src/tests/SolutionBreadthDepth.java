package tests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph_utils.*;
import search_algorithms.*;


public class SolutionBreadthDepth {
	Graph graph2 = new Graph();
	int i=0;
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		Node n5 = new Node("5");
		Node n6 = new Node("6");
		Node n7 = new Node("7");
		Node n8 = new Node("8");
		Node n9 = new Node("9");
		Node n10 = new Node("10");
		Node n11 = new Node("11");
	
		graph.addEdge(n6, n10);
		graph.addEdge(n10, n4);
		graph.addEdge(n4, n8);
		graph.addEdge(n4, n3);
		graph.addEdge(n8, n5);
		graph.addEdge(n3, n11); //objetivo
		graph.addEdge(n3, n9);
		graph.addEdge(n5, n2);
		graph.addEdge(n5, n1);
		graph.addEdge(n5, n11); //objetivo
		graph.addEdge(n9, n11); //objetivo
		graph.addEdge(n9, n7);
		
		System.out.println(graph.toString());
		
		System.out.println("initial node:" + n6.getLabel());
        System.out.println("final node:" + n11.getLabel());

        System.out.println("-----DFS-----");
        SearchAlgorithm dfsAlg= new DepthFirst(graph);
        dfsAlg.printResult(dfsAlg.startSearch(n6, n11));
        
        System.out.println(" ");
        
        System.out.println("-----BFS-----");
        SearchAlgorithm bfsAlg= new BreadthFirst(graph);
        dfsAlg.printResult(bfsAlg.startSearch(n6, n11));
        
	}
}
