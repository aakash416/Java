
/******************************************************************************
Print a given matrix in spiral form
Examples: 

Input:  1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Explanation: The output is matrix in spiral format. 

Input:  1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

*******************************************************************************/
import java.io.*;
import java.util.*;

class SpiralTraversalofthematrix {
	static void spiralPrint(int m, int n, int a[][]) {
		int i, k = 0, l = 0;
		while (k < m && l < n) {
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int a[][] = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				a[i][j] = sc.nextInt();
		spiralPrint(r, c, a);
	}
}
