package GET2018.DSA.DSSession6.UndirectedWeightedGraph;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs different Tests on ImplementationUsingMatrix class
 * 
 * @author Mohit Sharma
 *
 */
public class GraphTestUsingMatrix {
	ImplementationUsingMatrix graphMatrix;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() throws GraphException {
		// Input Graph
		// 0---1
		// |  /| \
		// | / |  2
		// |/  | /
		// 4---3
		graphMatrix = new ImplementationUsingMatrix(new int[][] { { 0, 5, 0, 0, 8 }, { 5, 0, 9, 10, 1 },
				{ 0, 9, 0, 4, 0 }, { 0, 10, 4, 0, 2 }, { 8, 1, 0, 2, 0 } });
	}

	@Test
	public void When_GraphConnected_Expect_True() {
		assertTrue(graphMatrix.isConnected());
	}

	@Test
	public void When_Vertex0Reachable_Expect_Vertex1Vertex4() throws GraphException {
		assertEquals(new LinkedList<Integer>(Arrays.asList(1, 4)), graphMatrix.reachable(0));
	}

	@Test
	public void When_Graph_Expect_MinimumSpanningTree() {
		// Minimum Spanning Tree
		// 0---1
		//    /
		//   /   2
		//  /   /
		// 4---3
		assertArrayEquals(new int[][] { { 0, 5, 0, 0, 0 }, { 5, 0, 0, 0, 1 }, { 0, 0, 0, 4, 0 }, { 0, 0, 4, 0, 2 },
				{ 0, 1, 0, 2, 0 } }, graphMatrix.minimumSpanningTree());
	}

	@Test
	public void When_GraphShortesdPathBetween0To2_Expect_ShortestPath12() throws GraphException {
		assertEquals(7, graphMatrix.shortestPath(1, 2));
	}

	@Test
	public void When_GraphIsNull_Expect_NullPointerException() throws GraphException {
		ex.expect(NullPointerException.class);
		ex.expectMessage("Graph can't be Null");
		graphMatrix = new ImplementationUsingMatrix(null);
	}

	@Test
	public void When_GraphMatrixNotSquare_Expect_GraphException() throws GraphException {
		ex.expect(GraphException.class);
		ex.expectMessage("Matrix is not Square");
		graphMatrix = new ImplementationUsingMatrix(new int[][] { { 1 }, { 1, 4 } });
	}

	@Test
	public void When_GraphNodeNotPresent_Expect_GraphException() throws GraphException {
		ex.expect(GraphException.class);
		ex.expectMessage("Given Node not Present in Graph");
		graphMatrix.reachable(5);
	}

	@Test
	public void When_GraphNodeNotPresentForShortestPath_Expect_GraphException() throws GraphException {
		ex.expect(GraphException.class);
		ex.expectMessage("Given Nodes not Present in Graph");
		graphMatrix.shortestPath(0, 6);
	}
}
