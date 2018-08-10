package GET2018.DSA.DSSession6.UndirectedWeightedGraph;

/**
 * This is custom Exception class for Graph
 * 
 * @author Mohit Sharma
 *
 */
@SuppressWarnings("serial")
public class GraphException extends Exception {
	String message;

	public GraphException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
