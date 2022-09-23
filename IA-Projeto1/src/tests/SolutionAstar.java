package tests;

import graph_utils.*;
import search_algorithms.*;

public class SolutionAstar {
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Node n1 = new Node("1",3);
		Node n2 = new Node("2",5);
		Node n3 = new Node("3",6);
		Node n4 = new Node("4",7);
		Node n5 = new Node("5",2);
		Node n6 = new Node("6",9);
		Node n7 = new Node("7",6);
		Node n8 = new Node("8",6);
		Node n9 = new Node("9",4);
		Node n10 = new Node("10",8);
		Node n11 = new Node("11",0);
		
		graph.addEdge(n6, n10, 1);
		graph.addEdge(n10, n4, 3);
		graph.addEdge(n4, n8, 12);
		graph.addEdge(n4, n3, 15);
		graph.addEdge(n8, n5, 13);
		graph.addEdge(n3, n11, 19); //objetivo
		graph.addEdge(n3, n9, 4);
		graph.addEdge(n5, n2, 13);
		graph.addEdge(n5, n1, 1);
		graph.addEdge(n5, n11, 1); //objetivo
		graph.addEdge(n9, n11, 9); //objetivo
		graph.addEdge(n9, n7, 9);
		
		
		System.out.println(graph.toString());
		
		System.out.println("initial node:" + n6.getLabel());
        System.out.println("final node:" + n11.getLabel());
        
        System.out.println("-----A*-----");
        SearchAlgorithm astarAlg = new Astar(graph);
        astarAlg.printResult(astarAlg.startSearch(n6, n11));
        
        //O custo da heuristica foi determinado com a utilização da distancia entre cada node e o node objetivo (Régua)
        //O custo dos arcos foi calculado com base nas quadriculas que estão presentes no gráfico no enunciado. (Número de Quadriculas)
		
	}
}
