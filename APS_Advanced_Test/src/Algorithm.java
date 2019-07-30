import java.util.Scanner;

public class Algorithm {

	static int lowestDifficulty;
	static int sizeLines;
	static int sizeColumns;
	
	// Recursion function
	static void calculateDifficulty(int [][] climbingMatrix, int [][] visited, int startX, int startY, int endX, int endY, int currentDifficulty)
	{
		visited[startX][startY] = 1;
		
		// Check if current lowest difficulty if lower or equal than current
		if (startX == endX && startY == endY)
		{
			if (currentDifficulty <= lowestDifficulty)
			{
				lowestDifficulty = currentDifficulty;
			}
			return;
		}
		
		// Check if lowest current difficulty is 1, since it's lowest possible difficulty, immediately exits
		if (lowestDifficulty == 1)
		{
			return;
		}
		
		// Horizontal movement
		if (startY - 1 >= 0)
		{
			if (climbingMatrix[startX][startY - 1] > 0 && visited[startX][startY - 1] == 0)
			{
				calculateDifficulty(climbingMatrix, visited, startX, startY - 1, endX, endY, currentDifficulty);
			}
		}
		
		if (startY + 1 < sizeColumns)
		{
			if (climbingMatrix[startX][startY + 1] > 0 && visited[startX][startY + 1] == 0)
			{
				calculateDifficulty(climbingMatrix, visited, startX, startY + 1, endX, endY, currentDifficulty);
			}
		}
		
		// Vertical movement
		for (int i = 1; i <= currentDifficulty; i++)
		{
			if (startX - i >= 0)
			{
				if (climbingMatrix[startX - i][startY] > 0 && visited[startX - i][startY] == 0)
				{
					calculateDifficulty(climbingMatrix, visited, startX - i, startY, endX, endY, currentDifficulty);
				}
			}
		}

		for (int i = 1; i <= currentDifficulty; i++)
		{
			if (startX + i < sizeLines)
			{
				if (climbingMatrix[startX + i][startY] > 0 && visited[startX + i][startY] == 0)
				{
					calculateDifficulty(climbingMatrix, visited, startX + i, startY, endX, endY, currentDifficulty);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int testcases = scan.nextInt();
		
		for (int testcase = 1; testcase <= testcases; testcase++)
		{
			lowestDifficulty = Integer.MAX_VALUE;
			int nLines = scan.nextInt();
			int nColumns = scan.nextInt();
			sizeLines = nLines;
			sizeColumns = nColumns;
			int startX = -1;
			int startY = -1;
			int endX = -1;
			int endY = -1;
			int climbingMatrix[][] = new int[nLines][nColumns];
			
			// Fill climbing matrix 
			for (int i = 0; i < nLines; i++)
			{
				for (int j = 0; j < nColumns; j++)
				{
					climbingMatrix[i][j] = scan.nextInt();
					if (climbingMatrix[i][j] == 2)
					{
						startX = i;
						startY = j;
					}
					if (climbingMatrix[i][j] == 3)
					{
						endX = i;
						endY = j;
					}
				}
			}
			
			// Increasing difficulty level
			for (int i = 1; i < 50; i++)
			{
				int [][] visited = new int[nLines][nColumns];
				visited[startX][endX] = 1;
				calculateDifficulty(climbingMatrix, visited, startX, startY, endX, endY, i);
				if (lowestDifficulty < Integer.MAX_VALUE)
					break;
			}
			
			System.out.println("#" + testcase + " " + lowestDifficulty);
		}
	}
}