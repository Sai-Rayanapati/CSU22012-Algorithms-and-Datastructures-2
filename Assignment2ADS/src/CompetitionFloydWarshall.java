import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {

	private int sA,sB,sC;
	private int V,E;
	public double[][] graph;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;

		try
		{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			int lineNum = 0;
			String currentLine;

			while(scanner.hasNextLine())
			{
				currentLine=scanner.nextLine();
				if(lineNum == 0)	
				{
					V= Integer.parseInt(currentLine);
					if(V<=2)
					{
						graph = null;
					}
					else
					{
						graph = new double[V][V];

						for(int j = 0; j < graph.length; j++)
						{
							for(int k = 0; k < graph[j].length; k++)
							{
								graph[j][k] = Integer.MAX_VALUE;
								if(j==k)
								{
									graph[j][k] = 0;
								}
							}	
						}
					}
				}
				else if(lineNum == 1)
				{
					E = Integer.parseInt(currentLine);
				}
				else
				{
					String [] line = currentLine.trim().split("\\s+");
					int intersection1= Integer.parseInt(line[0]);
					int intersection2= Integer.parseInt(line[1]);
					double distance=Double.parseDouble(line[2]);
					graph[intersection1][intersection2] = distance ;
				}
				lineNum++;	
			}

			scanner.close();
		}
		catch(Exception x)
		{
			graph = null;
			return;
		}
	}

	public double[][] floydWarshall(double graph[][])
	{
		V=graph.length;
		double dist[][] = new double[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < V; k++)
		{
			for (i = 0; i < V; i++)
			{
				for (j = 0; j < V; j++)
				{

					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		return dist;
	}

	public double largestDistance(double[][] dists) {
		double largestDist=0;
		for(double[] array:dists)
		{
			for(double dist : array)
			{
				if(largestDist< dist && dist!=Integer.MAX_VALUE)
				{
					largestDist= dist;
				}
			}
		}
		return largestDist;
	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){

		if(graph != null)
		{
			if(sA<50||sA>100||sB<50||sB>100||sC<50||sC>100)
			{
				return -1;
			}

			double[][] dist= floydWarshall(graph);

			double largestDist= largestDistance(dist);

			if(largestDist== Integer.MAX_VALUE)
			{
				return -1;
			}

			else
			{
				int[] nums = new int[]{sA, sB, sC};
				Arrays.sort(nums);
				int slowestSpeed= nums[0];

				int timeRequiredforCompetition= (int) Math.ceil((largestDist*1000)/slowestSpeed);

				return timeRequiredforCompetition;
			}			
		}	
		return -1;
	}


}