package search_algorithms;

import graph_utils.Edge;
import graph_utils.Graph;
import graph_utils.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Astar extends SearchAlgorithm {
	int k=0;
	int j=0;
	int aux=0;
	int aux2=0;
	int novo=0;

	Set<Node> nodeSet = new HashSet<>();
	List<Node> caminho = new ArrayList<Node>();

	ArrayList<Node> porCaminhar = new ArrayList<>();
	ArrayList<Node> caminhado = new ArrayList<Node>();
	List<Edge> adjacentEdges = new ArrayList<Edge>();
	Node[] vizinhos = new Node[getGraph().numberOfNodes()+1];

	public Astar(Graph graph) {
		super(graph);
	}

	@Override
	public List<Node> startSearch(Node n_initial, Node n_final) {
		// TODO Auto-generated method stub
		return super.startSearch(n_initial, n_final);
	}

	@Override
	public List<Node> start(Node n_initial, Node n_final) {

		aux=getGraph().getEdges().size();

		for(int i=0;i<aux;i++){
			Edge e = getGraph().getEdges().get(i);
			nodeSet.add(e.getN0());
			nodeSet.add(e.getN1());
		}

		//System.out.println(n_initial.getCost());
		
		porCaminhar = nodeSet.stream().sorted(Comparator.comparingInt(n -> Integer.parseInt(n.getLabel()))).collect(Collectors.toCollection(ArrayList<Node>::new));

		for(int i=0;i<porCaminhar.size();i++){
			porCaminhar.get(i).setCost(Integer.MAX_VALUE);
			//System.out.println(Integer.MAX_VALUE);

		}

		porCaminhar.get(Integer.parseInt(n_initial.getLabel())- 1).setCost(0);
		while (porCaminhar.size()>0) {

			adjacentEdges = getGraph().getAdjacencyList().get(n_initial);
			if (adjacentEdges != null) {

				aux2=adjacentEdges.size();
				for(int i=0;i<aux2;i++){
					Edge e = adjacentEdges.get(i);
					novo=Integer.parseInt(e.getN1().getLabel())-1;

					if (n_initial.getF() < e.getN1().getCost()) {
						e.getN1().setCost(n_initial.getF());
						//++e.getCost()
						vizinhos[novo] = n_initial;
					}
				}
			}
			caminhado.add(n_initial);
			porCaminhar.remove(n_initial);

			Node auxNode = n_initial;
			int minF = Integer.MAX_VALUE;

			int auxFor=porCaminhar.size();

			for(int i=0;i<auxFor;i++){
				Node no = porCaminhar.get(i);
				int indice = Integer.parseInt(no.getLabel()) - 1;
				if(vizinhos[indice]!=null&&no.getF()<minF){
					auxNode = no;
					minF=no.getF();
				}

			}
			n_initial=auxNode;
		}
		
		caminho.add(n_final);
		
		int indice = Integer.parseInt(n_final.getLabel()) - 1;

		while (vizinhos[indice] != null) {
			caminho.add(vizinhos[indice]);
			indice = Integer.parseInt(vizinhos[indice].getLabel()) - 1;
		}
		for(k=0,j=caminho.size()-1;k<j;k++){
			caminho.add(k,caminho.remove(j));
		}
		return caminho;
	}
}