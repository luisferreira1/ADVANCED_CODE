
public class Solution {

	public static int[] BFS(int[][] Graph, int[] visited)
	{
		Queue queue = new Queue(1000);
		visited[1] = 1;
		queue.enqueue(1);
		while (!queue.isEmpty())
		{
			int currentValue = queue.dequeue();
			System.out.print(currentValue + " ");
			visited[currentValue] = 1;
			
			for (int i = 0; i < Graph.length; i++)
			{
				if ((Graph[currentValue][i] == 1) && (visited[i] != 1))
				{
					visited[i] = 1;
					queue.enqueue(i);
				}
			}
		}
		return visited;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] graph = {{0,0,0,0,0,0,0,0},{0,0,1,1,0,0,0,0}, {0,1,0,0,1,1,0,0}, {0,1,0,0,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,0,1,0,0,0,1,0}, {0,0,0,0,1,1,0,1}, {0,0,0,1,0,0,1,0}};
		int [] visited = new int[9];
		BFS(graph, visited);
		
		
	}

}
