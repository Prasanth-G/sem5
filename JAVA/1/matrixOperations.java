import java.util.Arrays;

class MatrixOperations{
	public static void main(String args[]){
		int a[][] = {{33, 25, 16, 7},{8, 64, 23, 47},{53, 96, 81, 78},{83, 15, 100, 105}};
		int b[][] = {{3, 2, 1, 0},{0, 6, 2, 4},{5, 9, 8, 7},{8, 1, 1, 1}};
		int[][] c = MatrixOperations.add(a, b);
		System.out.println("Addition : ");
		for(int[] i : c){
			for(int j : i){
				System.out.printf("\t%d",j);
			}
			System.out.print("\n");
		}
		
		//int[][] a1 = {{3, 5, 6, 7},{8, 4, 3, 7},{3, 6, 1, 8},{3, 5, 0, 5}};
		//int[][] b1 = {{32, 23, 14, 50},{80, 76, 62, 54},{95, 89, 78, 67},{48, 31, 21, 11}};
		int[][] a1 = {{3, 5, 6, 7},{8, 4, 3, 7},{3, 6, 1, 8},{3, 5, 0, 5}, {1, 2, 3, 4}};
		int[][] b1 = {{32, 23, 14, 50, 1},{80, 76, 62, 54, 2},{95, 89, 78, 67, 3},{48, 31, 21, 11, 4}};
		int[][] d = MatrixOperations.mul(a1, b1);
		
		System.out.println("Multiplication : ");
		for(int[] i : d){
			for(int j : i){
				System.out.printf("\t%d",j);
			}
			System.out.print("\n");
		}
	}
	public static int[][] add(int[][] a, int[][] b){
		int[][] c1 = {{-1}};
		if (a.length == b.length){
			int[][] c = new int[a.length][a[0].length];
			for (int i=0; i < a.length; i++){
				for(int j=0; j < a[i].length; j++){
					c[i][j] = a[i][j] + b[i][j];
				}
			}
			return c;
		}
		return c1;
	}
	public static int[][] mul(int[][] a, int[][] b){
		int[][] c = new int[a.length][b[0].length];
		int sum;
		for(int i = 0; i < a.length;i++)
		{
			for(int j = 0;j < b[0].length;j++)
			{
				sum = 0;
				for(int k = 0; k < b.length ;k++)
				{
					sum += a[i][k]*b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return (c);
	}
}