package search_algorithms;
import search_algorithms.SearchAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import graph_utils.*;

public class BreadthFirst extends SearchAlgorithm{
	public List<Node> caminho=new ArrayList<Node>();
	public int[] aux = new int[getGraph().numberOfNodes()];
	
	public BreadthFirst(Graph graph) {
		super(graph);
	}

	@Override
	public List<Node> startSearch(Node n_initial, Node n_final) {
		return super.startSearch(n_initial, n_final);
	}
	
	@Override
	public List<Node> start(Node n_initial, Node n_final) {
		
		boolean used[] = new boolean[getGraph().numberOfNodes()+1];
		
		LinkedList<Integer> registo = new LinkedList();
		
		Stack<Node> stack = new Stack<>();
		
		int auxNode=Integer.parseInt(n_initial.getLabel());
				
		used[auxNode]=true;
		
		registo.add(auxNode);
		
		caminho.add(n_initial);
		
		while(registo.size()!=0){
			auxNode=registo.remove();
			
			Node n_finalAux=new Node(String.valueOf(auxNode));
			
			stack.add(n_finalAux);
				
			if(adjacencyOfNode(n_finalAux)==null){
				continue;
			}
			
			Iterator<Edge> iterador = getGraph().getAdjacencyList().get(n_finalAux).listIterator();
						
	    while(iterador.hasNext()){
	    
	    	Node aux=iterador.next().getN1();
	    	
	    	if(used[Integer.parseInt(aux.getLabel())]==false){
	    		caminho.add(aux);
	    	}
	    	
	    	if(!used[Integer.parseInt(aux.getLabel())]){
	    		if(n_final==aux){
	    			return caminho;
	    		}
	    		used[Integer.parseInt(aux.getLabel())]=true;
	    		registo.add(Integer.parseInt(aux.getLabel()));
	    	}
	    }
	    
		}
		return caminho;
	}
	
}


































