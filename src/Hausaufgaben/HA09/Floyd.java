package Hausaufgaben.HA09;

public class Floyd {

	public static int U = Integer.MAX_VALUE / 3;

	public static void main(String[] args) {
		/*
		int[][] a = {
			{ 0,10, U,30,100},
			{ U, 0,50, U,  U},
			{ U, U, 0, U, 10},
			{ U, U,20, 0, 60},
			{70, U, U, U,  0}};
		int[][] a = {
			{0,2,3,U},
			{2,0,5,1},
			{3,5,0,7},
			{U,1,7,0}};
		int[][] a = {
			{0,2,U,5},
			{U,0,4,1},
			{1,3,0,6},
			{U,U,1,0}};
		a)
		int[][] a = {
			{0,4,1,9},
			{4,0,8,1},
			{1,8,0,1},
			{9,1,1,0}};
		
		b)
		int[][] a = {
			{U,5,7,1},
			{5,U,1,3},
			{7,1,U,9},
			{1,3,9,U}};
		c)
		int[][] a = {
			{U,2,6,9},
			{9,U,1,U},
			{6,U,U,4},
			{1,6,8,U}};
		d)
		*/
		int[][] a = {
			{U,8,U,-2},
			{U,U,9,-4},
			{3,3,U,U},
			{0,8,U,U}};
		// int[][] a = {
		// 	{U,8,U,-2},
		// 	{U,U,9,-4},
		// 	{-3,3,U,U},
		// 	{0,8,U,U}};
			

		// Ausgabe
		for (int l = 0; l < a.length; l++) {
			for (int m = 0; m < a.length; m++) {
				if (a[l][m] == U) {
					System.out.print(" ---");
				} else {
					System.out.printf("%4d", a[l][m]);
				}
			}
			System.out.println();
		}
		System.out.println();

		// Floyd-Algorithmus
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (j == i) {
					continue;
				}
				for (int k = 0; k < a.length; k++) {
					if (k == i) {
						continue;
					}
					if (a[j][k] > a[j][i] + a[i][k]) {
						a[j][k] = a[j][i] + a[i][k];
					}
				}
			}
			// Ausgabe
			for (int l = 0; l < a.length; l++) {
				for (int m = 0; m < a.length; m++) {
					if (a[l][m] == U) {
						System.out.print(" ---");
					} else {
						System.out.printf("%4d", a[l][m]);
					}
				}
				System.out.println();
			}
			System.out.println();
		}

	}
}
