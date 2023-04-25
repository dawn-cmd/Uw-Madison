// --== CS400 File Header Information ==--
// Name: Huaiyuan Jing
// Email: hjing7@wisc.edu
// Group and Team: CC red
// Group TA: HAFEEZ ALI ANEES ALI
// Lecturer: Florian

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes.  This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class DijkstraGraph<NodeType, EdgeType extends Number>
    extends BaseGraph<NodeType,EdgeType>
    implements GraphADT<NodeType, EdgeType> {

    /**
     * While searching for the shortest path between two nodes, a SearchNode
     * contains data about one specific path between the start node and another
     * node in the graph.  The final node in this path is stored in it's node
     * field.  The total cost of this path is stored in its cost field.  And the
     * predecessor SearchNode within this path is referened by the predecessor
     * field (this field is null within the SearchNode containing the starting
     * node in it's node field).
     *
     * SearchNodes are Comparable and are sorted by cost so that the lowest cost
     * SearchNode has the highest priority within a java.util.PriorityQueue.
     */
    protected class SearchNode implements Comparable<SearchNode> {
        public Node node;
        public double cost;
        public SearchNode predecessor;
        public SearchNode(Node node, double cost, SearchNode predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }
        public int compareTo(SearchNode other) {
            if( cost > other.cost ) return +1;
            if( cost < other.cost ) return -1;
            return 0;
        }
    }
    
    private Node getNode(NodeType data) {
        for (Node node : nodes.values()) {
            if (node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }
    
    /**
     * This helper method creates a network of SearchNodes while computing the
     * shortest path between the provided start and end locations.  The
     * SearchNode that is returned by this method is represents the end of the
     * shortest path that is found: it's cost is the cost of that shortest path,
     * and the nodes linked together through predecessor references represent
     * all of the nodes along that shortest path (ordered from end to start).
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return SearchNode for the final end node within the shortest path
     * @throws NoSuchElementException when no path from start to end is found
     *         or when either start or end data do not correspond to a graph node
     */
    protected SearchNode computeShortestPath(NodeType start, NodeType end) {
        PriorityQueue<SearchNode> pq = new PriorityQueue<>();
        Hashtable<NodeType, SearchNode> visited = new Hashtable<>();
        
        Node startNode = getNode(start);
        Node endNode = getNode(end);
        
        if (startNode == null || endNode == null) {
            throw new NoSuchElementException();
        }
        
        pq.add(new SearchNode(startNode, 0, null));
        
        while (!pq.isEmpty()) {
            SearchNode current = pq.poll();
            if (current.node.data.equals(end)) {
                return current;
            }
            if (!visited.containsKey(current.node.data)) {
                visited.put(current.node.data, current);
                for (Edge edge : current.node.edgesLeaving) {
                    Node neighbor = (edge.predecessor == current.node) ? edge.successor : edge.predecessor;
                    double newCost = current.cost + edge.data.doubleValue();
                    
                    if (!visited.containsKey(neighbor.data)) {
                        pq.add(new SearchNode(neighbor, newCost, current));
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns the list of data values from nodes along the shortest path
     * from the node with the provided start value through the node with the
     * provided end value.  This list of data values starts with the start
     * value, ends with the end value, and contains intermediary values in the
     * order they are encountered while traversing this shorteset path.  This
     * method uses Dijkstra's shortest path algorithm to find this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return list of data item from node along this shortest path
     */
    public List<NodeType> shortestPathData(NodeType start, NodeType end) {
        SearchNode endSearchNode = computeShortestPath(start, end);
        LinkedList<NodeType> path = new LinkedList<>();
        
        while (endSearchNode != null) {
            path.addFirst(endSearchNode.node.data);
            endSearchNode = endSearchNode.predecessor;
        }
        
        return path;
    }

    /**
     * Returns the cost of the path (sum over edge weights) of the shortest
     * path freom the node containing the start data to the node containing the
     * end data.  This method uses Dijkstra's shortest path algorithm to find
     * this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return the cost of the shortest path between these nodes
     */
    public double shortestPathCost(NodeType start, NodeType end) {
        SearchNode endSearchNode = computeShortestPath(start, end);
        return endSearchNode.cost;
    }

    // TODO: implement 3+ tests in step 8.
    static class DijkstraGraphTest {
        private DijkstraGraph<String, Integer> graph;
        
        @BeforeEach
        void setUp() {
            graph = new DijkstraGraph<>();
            graph.insertNode("A");
            graph.insertNode("B");
            graph.insertNode("C");
            graph.insertNode("D");
            graph.insertNode("E");
            
            graph.insertEdge("A", "B", 10);
            graph.insertEdge("A", "C", 15);
            graph.insertEdge("B", "D", 12);
            graph.insertEdge("C", "D", 4);
            graph.insertEdge("C", "E", 5);
            graph.insertEdge("D", "E", 8);
        }
        
        @Test
        void testShortestPathDataExampleFromLecture() {
            List<String> expectedPath = Arrays.asList("A", "C", "E");
            assertEquals(expectedPath, graph.shortestPathData("A", "E"));
        }
        
        @Test
        void testShortestPathCostExampleFromLecture() {
            double expectedCost = 20;
            assertEquals(expectedCost, graph.shortestPathCost("A", "E"));
        }
        
        @Test
        void testShortestPathDataDifferentStartEnd() {
            List<String> expectedPath = Arrays.asList("B", "D");
            assertEquals(expectedPath, graph.shortestPathData("B", "D"));
        }
        
        @Test
        void testShortestPathCostDifferentStartEnd() {
            double expectedCost = 12;
            assertEquals(expectedCost, graph.shortestPathCost("B", "D"));
        }
        
        @Test
        void testUnreachableNodes() {
            graph.insertNode("F");
            graph.insertNode("G");
            assertThrows(NoSuchElementException.class, () -> graph.shortestPathData("A", "G"));
            assertThrows(NoSuchElementException.class, () -> graph.shortestPathCost("A", "G"));
        }
    }
}
