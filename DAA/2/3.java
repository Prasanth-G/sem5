import java.util.Arrays;

class BinarySearch{
	public static void main(String args[]){
		//int a[] = {23, 45, 86, 77, 9, 54, 13, 36, 61, 98};
		int[][] a = {{5, 10, 15, 20, 25}, {6, 11, 16, 21, 26}, {7,12,17,22,27}, {8,13,18,23,28},{9,14,19,24,29}};
		int x = 22;
		int col=0, row=0;		
		BinarySearch search = new BinarySearch();
		for (row = 0;row < a.length; row++){
			col = search.Search(a[row], x, 0, a[row].length-1);
			if (col != -1){
				break;
			}		
		}
		if (col != -1){
			row++;
			col++;
			System.out.println("Row : "+row+"\nColumn : "+col);
		}
		else{
			System.out.println("Element not Found");
		}
	}
	public int Search(int arr[],int element, int low, int high){
		int prev_low = low, prev_high = high;
		while( low < high){
			int mid = (low + high) / 2;
			if (arr[mid] == element){
				return (mid);
			}
			else if(arr[mid] < element){
				low = mid+1;
			}
			else{
				high = mid-1;
			}
		}
		return (-1);
	}
}