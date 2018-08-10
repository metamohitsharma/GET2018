package GET2018.DSA.DSSession6.UndirectedWeightedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * This class implements UndirectedWeightedGraph interface methods
 * 
 * @author Mohit Sharma
 *
 */
public class Implementation implements UnidrectedWeightedGraph {

	int[][] graph;

	public Implementation(int[][] graph) throws GraphException {
		if (graph.length != graph[0].length) {
			throw new GraphException("Matrix is not Square");
		}
		this.graph = graph;
	}

	@Override
	public boolean isConnected() {
		Stack<Integer> stackOfVertices = new Stack<Integer>();
		Set<Integer> traversedElements = new HashSet<Integer>();
		stackOfVertices.push(0);
		while (!stackOfVertices.isEmpty()) {
			int deletedElement = stackOfVertices.pop();
			traversedElements.add(deletedElement);
			for (int j = 0; j < graph[0].length; j++) {
				if (traversedElements.contains(j)) {
					continue;
				} else if (graph[deletedElement][j] > 0) {
					stackOfVertices.push(j);
				}
			}
		}
		return traversedElements.size() == graph.length;
	}

	@Override
	public List<Integer> reachable(int node) {
		List<Integer> reachableVertices = new ArrayList<Integer>();
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[node][j] > 0) {
				reachableVertices.add(j);
			}
		}
		return reachableVertices;
	}

	@Override
	public int[][] minimumSpanningTree() {
		List<Integer> treeNodes = new LinkedList<Integer>();
		int minimumWeightedTree[][] = new int[graph.length][graph[0].length];
		minimumWeightedTree[0][0] = 0;
		treeNodes.add(0);
		int minWeight = Integer.MAX_VALUE;
		int startVertex = 0;
		int endVertex = 0;
		int sizeOfTree = treeNodes.size();
		for (int i = treeNodes.get(0), k = 0; sizeOfTree != graph.length;) {
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] != 0 && !treeNodes.contains(j) && graph[i][j] < minWeight) {
					endVertex = j;
					startVertex = i;
					minWeight = graph[i][j];
				}
			}
			if (k < sizeOfTree - 1) {
				k++;
				i = treeNodes.get(k);
			} else if (k == sizeOfTree - 1) {
				treeNodes.add(endVertex);
				sizeOfTree = treeNodes.size();
				minimumWeightedTree[startVertex][endVertex] = minWeight;
				minimumWeightedTree[endVertex][startVertex] = minWeight;
				k = 0;
				i = treeNodes.get(k);
				minWeight = Integer.MAX_VALUE;
			}
		}
		return minimumWeightedTree;
	}
}
