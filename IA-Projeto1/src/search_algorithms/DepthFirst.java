package search_algorithms;

import search_algorithms.SearchAlgorithm;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graph_utils.*;

public class DepthFirst extends SearchAlgorithm {
	public List<Node> caminho=new ArrayList<Node>();
	public int[] aux = new int[getGraph().numberOfNodes()];

	public DepthFirst(Graph graph) {
		super(graph);
	}

	@Override
	public List<Node> startSearch(Node n_initial, Node n_final) {
		return super.startSearch(n_initial, n_final);
	}

	@Override
	public List<Node> start(Node n_initial, Node n_final) {

		boolean[] used = new boolean[getGraph().numberOfNodes()+1];

		Stack<Node> stack = new Stack<>();

		stack.push(n_initial);

		Node a;

		while(!stack.empty()){
			for(int h=0;h<stack.size();h++){
				for(int j=h+1; j<stack.size();j++){
					if(stack.get(h)==stack.get(j)){
						stack.remove(h);
					}
				}
			}

			n_initial=stack.peek();
			stack.pop();

			ByteArrayOutputStream reader = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(reader);
			PrintStream old = System.out;
			System.setOut(ps);
			System.out.println((adjacencyOfNode(n_initial)));
			System.out.flush();
			System.setOut(old);

			if(reader.toString().contains("null")){
				used[Integer.parseInt(n_initial.getLabel())]=true;
				caminho.add(n_initial);

				if(n_initial!=n_final){
					continue;
				}

				if(n_initial==n_final){
					break;
				}
			}

			if(used[Integer.parseInt(getGraph().getAdjacencyList().get(n_initial).get(0).getN1().getLabel())]==false){

				caminho.add(n_initial);
				used[Integer.parseInt(getGraph().getAdjacencyList().get(n_initial).get(0).getN0().getLabel())]=true;
			}

			if(n_initial==n_final){
				break;
			}

			for(int i=0;i<getGraph().getAdjacencyList().get(n_initial).size();i++){
				a=getGraph().getAdjacencyList().get(n_initial).get(i).getN1();

				if(!used[Integer.parseInt(a.getLabel())]){
					stack.push(a);
				}
			}
		}

		return caminho;
	}

}
