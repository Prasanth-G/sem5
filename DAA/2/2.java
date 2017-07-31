import java.util.Arrays;

class BinarySearch{
	public static void main(String args[]){
		int a[] = {98,23, 45, 86, 77, 9, 54, 13, 36, 61};
		int max=0, max_1 = 0;
		if (a[0] > a[1]){
			max = a[0];
			max_1 = a[1];
		}
		for (int i = 2;i < a.length; i++){
			if (a[i] > max){
				max_1 = max;
				max = a[i];
			}
			else if(a[i] > max_1){
				max_1 = a[i];
			}
		}
		int sum = max + max_1;
		System.out.println("Largest pair sum : "+sum);
	}
}