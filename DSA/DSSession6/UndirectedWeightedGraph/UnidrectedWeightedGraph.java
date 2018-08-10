package GET2018.DSA.DSSession6.UndirectedWeightedGraph;

import java.util.List;

/**
 * This interface contains different methods on UndirectedWeighted Graph
 * 
 * @author Mohit Sharma
 *
 */
public interface UnidrectedWeightedGraph {

	/**
	 * Returns true is the Graph is a Connected Graph
	 * 
	 * @return
	 */
	public boolean isConnected();

	/**
	 * Returns all the Nodes that are Reachable from node
	 * 
	 * @param node
	 * @return
	 */
	public List<Integer> reachable(int node);

	/**
	 * Return the Minimum Spanning Tree for the Graph
	 * 
	 * @return
	 */
	public int[][] minimumSpanningTree();
}
