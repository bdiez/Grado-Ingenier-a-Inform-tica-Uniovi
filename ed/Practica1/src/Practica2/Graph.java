package Practica2;

public class Graph {

	
	private Object[] nodes;
	private double[][] weight;
	private boolean[][] edge;
	public int numNodes;
	
	
	public Graph(){
		nodes = new Object[20];
		weight = new double[20][20];
		edge = new boolean[20][20];
		numNodes = 0;
	}
	
	/**
	 * @param node
	 * @return 1 si no puede meter el nodo, 0 si lo mete
	 */
	public int addNode(Object node){
		if(nodes.length < numNodes || existNode(node)) 
			return -1;
		else
			nodes[numNodes] = nodes;
			for(int i=0; i<=numNodes; i++){
				edge[i][numNodes] = false;
				edge[numNodes][i] = false;
				weight[i][numNodes] = 0;
				weight[numNodes][i] = 0;
			}
			numNodes++;
			return 0;
	}
	
	public boolean existNode(Object node){
		if (getNode(node)==-1)
			return false;
		else
			return true;
	}
	
	
	
	public int getNode(Object node){
		for (int i=0; i<numNodes; i++){
			if(nodes[i].equals(node))
				return i;
		}
		return -1;
	}
	
	
	public int addEdge(Object source, Object target, double edgeWeight){
		if(existNode(source) && existNode(target)){
			edge[getNode(source)][getNode(target)] = true;
			weight[getNode(source)][getNode(target)] = edgeWeight;
			return 0;
		}
		return -1;
	}
	
	public int removeEdge(Object source, Object target){
		if(existNode(source) && existNode(target)){
			edge[getNode(source)][getNode(target)] = false;
			weight[getNode(source)][getNode(target)] = 0;
			return 0;
		}
		return -1;
		
	}
	
	public int removeNode(Object node){
		if(existNode(node)){
			nodes[getNode(node)] = nodes[numNodes-1];
			int posicionNodo = getNode(node);
			
			for(int i=0; i<=numNodes; i++){
				edge[i][posicionNodo] = edge[i][numNodes-1];
				edge[posicionNodo][i] = edge[numNodes-1][i];
				weight[i][posicionNodo] = weight[i][numNodes-1];
				weight[posicionNodo][i] = weight[numNodes-1][i];
				
				edge[posicionNodo][posicionNodo]= edge[numNodes-1][numNodes-1];
				weight[posicionNodo][posicionNodo]= weight[numNodes-1][numNodes-1];
				
//				edge[i][numNodes-1] = false;
//				edge[numNodes-1][i] = false;
//				weight[i][numNodes-1] = 0;
//				weight[numNodes-1][i] = 0;
				
		}
			nodes[numNodes-1] = null;
			numNodes--;
			return 0;
	}
		return -1;
	}
	
	
	
	
	
	

	
}
	


