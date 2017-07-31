import java.util.Arrays;

class Search{
	public static void main(String args[]){
		int arr[] = {23, 45, 86, 77, 9, 54, 13, 36, 61, 98};
		int x = 9;
		/************ Linear Search ********************/
		int index = Search.linearSearch(arr,x);
		if ( index != -1){
			System.out.println("Element "+ arr[index] +" Found at index "+ index);
		}else{
			System.out.println("Element not found");
		}
		/************ Binary Search ********************/
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		index = Search.binarySearch(arr, x, 0, arr.length,0);
		if ( index != -1){
			System.out.println("Element "+ arr[index] +" Found at index "+ index);
		}else{
			System.out.println("Element not found");
		}
		/************ Linear Search 2D ********************/
		int a[][] = {{33, 25, 16, 7},{8, 64},{53, 96, 81, 78},{83, 15}};
		x = 96;
		int ind[] = Search.linearSearch2D(a,x);
		if ( ind[0] != -1){
			System.out.println("Element "+ x +" Found at indices "+ Arrays.toString(ind));
		}else{
			System.out.println("Element not found");
		}
	}
	public static int binarySearch(int arr[],int element, int low, int high, int count){
		if( low < high){
			int mid = (low + high) / 2;
			if (arr[mid] == element){
				count++;
				System.out.println("No of Comparisons : " + count);
				return (mid);
			}
			else if(arr[mid] < element){
				count++;
				return Search.binarySearch(arr,element,mid+1,high,count);
			}
			else{
				count++;
				return Search.binarySearch(arr,element,low,mid-1,count);
			}
		}else{
			return (-1);
		}
	}
	public static int linearSearch(int arr[], int element){
		for(int i=0;i < arr.length; i++){
			if(arr[i] == element){
				return (i);
			}
		}
		return (-1);
	}
	public static int[] linearSearch2D(int arr[][], int element){
			int index[] = {-1, -1};
			for(int i=0;i < arr.length; i++){
				for(int j=0; j< arr[i].length; j++){
					if(arr[i][j] == element){
						index[0] = i;
						index[1] = j;
						break;
					}
				}
			}
			return index;
	}
}
