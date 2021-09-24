/******************************************************************************

Given a boolean 2D matrix, find the number of islands. A group of connected 1s 
forms an island. For example, the below matrix contains 5 islands
Example: 
 

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} 
Output : 5

*******************************************************************************/
import java.util.*;
import java.lang.*;
import java.io.*;

class Islands {
	static final int ROW = 5, COL = 5;

	boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);

	}

	void DFS(int M[][], int row, int col, boolean visited[][])

	{
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[row][col] = true;
		for (int k = 0; k < 8; ++k)
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);

	}

	int countIslands(int M[][]) {
		boolean visited[][] = new boolean[ROW][COL];
		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == 1 && !visited[i][j]) {
					DFS(M, i, j, visited);
					++count;
				}
		return count;
	}

	public static void main(String[] args) throws java.lang.Exception {

		int i, j;
		Scanner sc = new Scanner(System.in);
		int M[][] = new int[ROW][COL];
		for (i = 0; i < ROW; i++)
			for (j = 0; j < COL; j++)
				M[i][j] = sc.nextInt();

		Islands I = new Islands();
		System.out.println(I.countIslands(M));
	}
}