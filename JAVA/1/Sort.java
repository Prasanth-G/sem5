import java.util.Arrays;

class Sort{
	public static void main(String args[]){
		int arr[] = {23, 45, 86, 77, 9, 54, 13, 36, 61, 98};
		//int arr[] = {9,8,7,6,5,4,3,2,1,0};
		System.out.println("Initial Array :\t"+Arrays.toString(arr));
		
		//Sort.selectionSort(arr);
		//Sort.mergeSort(arr);
		Sort.quickSort(arr);
		System.out.println("Sorted Array :\t"+Arrays.toString(arr));
	}
	/******* Quick sort ***************/
	public static void partition(int arr[], int low, int high){
		int pivot_index = (low + high) / 2;
		int pointer = low, temp;
		for (int i=0; i < high; i++){
			if (arr[i] > arr[pivot_index]){
				if (pointer != i){
					temp = arr[pointer];
					arr[pointer] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	public static void quicksort(int arr[], int low, int high){
		if (low < high){
			int mid = (low + high) / 2;
			Sort.partition(arr, low, mid);
			Sort.quicksort(arr, low, mid);
			Sort.partition(arr, mid+1, high);
			Sort.quicksort(arr, mid+1, high);	
		}
	}
	public static void quickSort(int arr[]){
		Sort.partition(arr, 0, arr.length-1);
		Sort.quicksort(arr, 0, arr.length-1);
	}
	public static void selectionSort(int arr[]){
		int index, temp;
		for(int i=0; i < arr.length; i++){
			index = i;
			for(int j=index; j < arr.length; j++){
				if (arr[j] < arr[index]){
					index = j;
				}
			}
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
	public static int[] mergeSort(int arr[]){
		Sort.mergesort(arr, 0, arr.length-1);
		//System.out.println(Arrays.toString(arr));
		return (arr);
	}
	private static void mergesort(int arr[], int low, int high){
		if (low < high){
			int mid = (low + high) / 2;
			mergesort(arr, low, mid);
			mergesort(arr, mid+1, high);
			Sort.merge(arr, low, high);
			//System.out.println(Arrays.toString(arr));
		}
	}
	private static void merge(int[] arr, int low, int high){		
		int[] new_arr = new int[high-low+1];
		int mid = (low + high) / 2, count = 0, i=low, j=mid+1;
		while( i <= mid && j <= high){
			if (arr[i] < arr[j]){
				new_arr[count] = arr[i];
				i++;
			}
			else{
				new_arr[count] = arr[j];
				j++;
			}
			count++;
		}
		while(i <= mid){
			new_arr[count] = arr[i];
			i++;
			count++;
		}
		while(j <= high){
			new_arr[count] = arr[j];
			j++;
			count++;
		}
		for(int temp : new_arr){
			arr[low] = temp;
			low++;
		}
	}
}