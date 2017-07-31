/**
 *
 * @author 15pt25
 */
class Matrix{
	private int elements[][];
	Matrix(int rows, int columns){
		elements = new int[rows][columns];
	}
	void setElement( int row, int column, int element){
		elements[row][column] = element;
	}
	int getElement( int row, int column){
		return elements[row][column];
	}
	int getRowLength(){
		return elements.length;
	}
	int getColLength(){
		return elements[0].length;
	}

	public Matrix add(Matrix m){
		Matrix c = new Matrix(m.elements.length, elements[0].length);
		if (m.elements.length == elements.length && m.elements[0].length == elements[0].length){
			for (int i=0; i < m.elements.length; i++){
				for(int j=0; j < m.elements[i].length; j++){
					c.setElement(i, j, m.getElement(i, j) + elements[i][j]);
				}
			}
			return c;
		}else{
			System.out.println("Error : Improper Matrix dimension");
			return c;			
		}
	}
	public Matrix subtract(Matrix m){
		Matrix c = new Matrix(m.elements.length, elements[0].length);
		if (m.elements.length == elements.length && m.elements[0].length == elements[0].length){
			for (int i=0; i < m.elements.length; i++){
				for(int j=0; j < m.elements[i].length; j++){
					c.setElement(i, j, m.getElement(i, j) - elements[i][j]);
				}
			}
			return c;
		}else{
			System.out.println("Error : Improper Matrix dimension");
			return c;
		}
	}
	public Matrix multiply(Matrix mat){
		int m1 = this.getRowLength(), n1 = this.getColLength();
		int m2 = mat.getRowLength(), n2 = mat.getColLength();
		Matrix out = new Matrix(m1, n2);
		if (n1 == m2){
			int sum;
			
			for (int i=0; i < m1; i++){
				for (int j=0; j < n2; j++){
					sum = 0;
					for(int k=0; k < m2; k++){
						sum +=  this.getElement(i,k) * mat.getElement(k,j);
						//System.out.println(" "+i+k+k+j);
					}
					out.setElement(i, j, sum);
				}
			}
			return out;
		}else{
			System.out.println("Error : Improper Matrix dimension");
			return out;
		}
	}
	
	public String toString(){
		String s = "";
		for(int[] i : elements){
			for(int j : i){
				s += j + "\t";
			}
			s += '\n';
		}
		return s;
	}
	
	public static void main(String args[]){
		Matrix a = new Matrix(4,4);
		Matrix b = new Matrix(4,4);
		int a1[][] = {{33, 25, 16, 7},{8, 64, 23, 47},{53, 96, 81, 78},{83, 15, 100, 105}};
		int b1[][] = {{1, 1, 0, 0},{0, 6, 2, 4},{5, 9, 8, 7},{8, 1, 1, 1}};
		//int a1[][] = {{33, 25, 16},{8, 64, 23}};
		//int b1[][] = {{3, 2, 1},{0, 6, 2},{0, 9, 8}};
		for (int i=0; i < a1.length; i++){
			for (int j=0; j < a1[i].length; j++){
				a.setElement(i, j, a1[i][j]);
			}
		}
		for (int i=0; i < b1.length; i++){
			for (int j=0; j < b1[i].length; j++){
				b.setElement(i, j, b1[i][j]);
			}
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println("Addition : \n" +a.add(b));
		System.out.println("subtraction : \n" +a.subtract(b));
		System.out.println("Multiplication : \n"+ a.multiply(b));
	}
}