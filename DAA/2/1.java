import java.util.*;

class Find{
	public static void main(String[] args){
		//int arr1[] = {1,3,5,7,9,11,13,15,17,19};
		//int arr2[] = {2,4,6,7,8,9,10};
		//int arr1[] = {0,1,2,8,10,11};
		//int arr2[] = {3,4,5,7,9};
		//int arr1[] = {0,1,2,8,11,12,14};
		//int arr2[] = {3,4,7,9,10,13};
		int arr1[] = {1,2,3,6,9,10,13};
		int arr2[] = {4,5,7,8,11,12,14};
		Scanner s = new Scanner(System.in);
		System.out.print("Enter K : ");
		int k = s.nextInt();
		System.out.println(k);

		int end1 = arr1.length - 1, end2 = arr2.length - 1, mid;
		while(end1 + end2 + 2 != k){
			
			System.out.println(end1 +"ASDF"+ end2);
			if(arr1[end1] > arr2[end2]){
				mid = end1/2;
				if (mid + end2 + 2 < k){
					end1 = mid + mid/2;					
				}
				else{
					end1 = end1/2;
				}
			}
			else{
				mid = end2/2;
				if (mid + end1 + 2 < k){
					end2 = mid + mid/2;					
				}
				else{
					end2 = end2/2;
				}
			}
			if(end1 + end2 + 2 == k){
				if (arr1[end1] > arr2[end2]){
					mid = end1/2;
					if (mid + end2 + 2 < k){
						end1 = mid + mid/2;					
					}
					else{
						end1 = end1/2;
					}
				}
				else{
					mid = end2/2;
					if (mid + end1 + 2 < k){
						end2 = mid + mid/2;					
					}
					else{
						end2 = end2/2;
					}
				}
			}
		}
		System.out.println(arr1[end1] +"aaa"+arr2[end2] );
	}
}