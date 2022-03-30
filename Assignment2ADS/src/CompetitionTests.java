import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

import java.io.File;

/*
 *  Choice of data structures:
 *     - For the adjacency table in the Graph class I used an array of Hashsets
 *       as this results in a faster runtime due to accesses.
 *     - I held the distances in a 2d array as it was very easy to access and
 *       compare values.
 *     
 *  Differences between Dijkstra and Floyd-Warshall
 *      - In this problem we need to find the longest possible
 *          time taken from any point so floyd warshall suits
 *          better for this problem as it returns the required 2d
 *          array
 *      - Dijstra is not effected by the denser graphs as much as 
 *          it uses a hashset list instead of a matrix, floyd warshall improves
 *          on denser datasets however as it is not dependant on a queue. I would chose
 *          mu dijkstra for both as it would beat out floyd warshall.
 */

public class CompetitionTests {
    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra graph;
    	int sA = 75;
    	int sB = 56;
    	int sC = 87;
    	int minTime;
    	
//    	// for 1000EWD 
//    	String filename = "/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/1000EWD.txt";
//    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
//    	minTime= graph.timeRequiredforCompetition();
//    	assertEquals(25,minTime);
    	
    	// for tinyEWD
    	String filename = "tinyEWD.txt";
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(34,minTime);
        
        // for different speeds
    	sA = 63;
    	sB = 76;
    	sC = 99;
    	
//    	// for 1000EWD
//    	filename = "/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/1000EWD.txt";
//    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
//    	minTime= graph.timeRequiredforCompetition();
//    	assertEquals(23,minTime);
    	
    	// for tinyEWD
    	filename = "tinyEWD.txt";
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(30,minTime);
    	
    	// for Invalid speeds
    	
    	sA = 102;
    	sB = 76;
    	sC = 99;
    	
    	// for 1000EWD
//    	filename = "/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/1000EWD.txt";
//    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
//    	minTime= graph.timeRequiredforCompetition();
//    	assertEquals(-1,minTime);
    	
    	// for tinyEWD
    	filename = "tinyEWD.txt";
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);
    	
    	//Input path Errors
    	
    	filename = "Input.txt";
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);

    	filename = "Nopath";
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);
    	
    	filename = null;
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);
    	
    }

    @Test
    public void testFWConstructor() {
    	CompetitionFloydWarshall graph;
    	int sA = 75;
    	int sB = 56;
    	int sC = 87;
    	int minTime;
    	
    	// for 1000EWD
//    	String filename = "/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/1000EWD.txt";
//    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
//    	minTime= graph.timeRequiredforCompetition();
//    	assertEquals(25,minTime);
    	
    	// for tinyEWD
        String filename = "tinyEWD.txt";
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(34,minTime);
        
        // for different speeds
    	sA = 63;
    	sB = 76;
    	sC = 99;
    	
    	// for 1000EWD
//    	filename = "/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/1000EWD.txt";
//    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
//    	minTime= graph.timeRequiredforCompetition();
//    	assertEquals(23,minTime);
    	
    	// for tinyEWD
    	filename = "tinyEWD.txt";
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(30,minTime);
    	
    	// for Invalid speeds
    	
    	sA = 102;
    	sB = 76;
    	sC = 99;
    	
    	// for 1000EWD
//    	filename = "/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/1000EWD.txt";
//    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
//    	minTime= graph.timeRequiredforCompetition();
//    	assertEquals(-1,minTime);
    	
    	// for tinyEWD
    	filename = "tinyEWD.txt";
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);
    	
    	//Input path Errors
    	
    	filename = "Input.txt";
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);

    	filename = "Nopath";
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);
    	
    	filename = null;
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	minTime= graph.timeRequiredforCompetition();
    	assertEquals(-1,minTime);
    	
    }
	
	@Test
	public void testA() 
	{
		CompetitionDijkstra graph = new CompetitionDijkstra("input-A.txt",60,50,70);
		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("input-A.txt",60,70,80);
		assertEquals("Test competition with inputA", -1, graph.timeRequiredforCompetition());
		assertEquals("Test competition with inputA", -1, graph1.timeRequiredforCompetition());
	}
//	@Test
//	public void testB() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
	@Test
	public void testC() 
	{
		CompetitionDijkstra graph = new CompetitionDijkstra("input-C.txt",60,70,80);
		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("input-C.txt",60,70,80);
		assertEquals("Test competition with inputA", 3334, graph1.timeRequiredforCompetition());
		assertEquals("Test competition with inputA", 3334, graph.timeRequiredforCompetition());
	}
//	@Test
//	public void testD() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
//	@Test
//	public void testE() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
//	@Test
//	public void testF() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
//	@Test
//	public void testG() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
//	@Test
//	public void testH() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
//	@Test
//	public void testI() 
//	{
//		CompetitionDijkstra graph = new CompetitionDijkstra("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("/Users/subbu/Desktop/eclipse-workspace/Assignment2ADS/src/input-A.txt",60,70,80);
//		assertEquals("Test competition with inputA", 2500, graph.timeRequiredforCompetition());
//		assertEquals("Test competition with inputA", 2500, graph1.timeRequiredforCompetition());
//	}
	@Test
	public void testJ() 
	{
		CompetitionDijkstra graph = new CompetitionDijkstra("input-J.txt",60,70,80);
		CompetitionFloydWarshall graph1 = new CompetitionFloydWarshall("input-J.txt",60,70,80);
		assertEquals("Test competition with inputA", -1, graph1.timeRequiredforCompetition());
		assertEquals("Test competition with inputA", -1, graph.timeRequiredforCompetition());
	}
	
	
    

}