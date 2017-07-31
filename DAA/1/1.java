import java.util.*;

class problem1{
	public static void main(String[] args){
		int arr[] = {1,3,5,7,9,11,13,15,17,19};
		Scanner s = new Scanner(System.in);
		System.out.print("Enter N : ");
		int n = s.nextInt();
		//System.out.println(n);
		int temp,i;
		int last = n-1;
		//System.out.println(last);
		
		for(i=0;true; i++){
			//System.out.println(arr[i]);
			if(arr[i] % 2 != 0){
				while(i < last && arr[last]%2 != 0){
					//System.out.format("%d %d\n",arr[last],arr[last]%2);
					last--;
				}
				if(i > last){
				   break;
				}
				temp = arr[i];
				arr[i] = arr[last];
				arr[last] = temp;
				last--;
			}
		}
		for(i=0;i < n; i++){
			System.out.println(arr[i]);
		}
	}
}