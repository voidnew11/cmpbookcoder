package com.zr.test1;

import java.util.Scanner;

	public class Grid {

		private static int n;
		private static int m;

		public static int numIslands(char[][] grid) {
		    int count = 0;
		    n = grid.length;
		    if (n == 0) return 0;
		    m = grid[0].length;
		    for (int i = 0; i < n; i++){
		        for (int j = 0; j < m; j++)
		            if (grid[i][j] == '1') {
		                DFSMarking(grid, i, j);
		                ++count;
		            }
		    }    
		    return count;
		}

		private static void DFSMarking(char[][] grid, int i, int j) {
		    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
		    grid[i][j] = '0';
		    DFSMarking(grid, i + 1, j);
		    DFSMarking(grid, i - 1, j);
		    DFSMarking(grid, i, j + 1);
		    DFSMarking(grid, i, j - 1);
		}
		public static void main(String[] args){
		    Scanner sc = new Scanner(System.in);
		     n = sc.nextInt();
		     m = sc.nextInt();
		    int k = sc.nextInt();
		    char[][] a = new char[n][m];
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < m; j++){
		        	a[i][j] = '0';
		        }
		    }
		    for(int i = 0; i < k; i++){
		    	int t1 = sc.nextInt();
		    	int t2 = sc.nextInt();
		    	a[t1][t2] = '1';
		    	if(i == k -1){
		    		System.out.print(numIslands(a));
		    	}else{
		    		System.out.print(numIslands(a));
		    		System.out.print(" ");
		    	}
		    }
		}

		}

