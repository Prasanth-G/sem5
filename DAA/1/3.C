#include<iostream>
#include<algorithm>
using namespace std;

int main(){
   int n = 10;
   //cout<<"Size of the array : ";
   //cin>>n;
   int arr[10] = {2,2,1,2,5,2,9,2,2,7};
   int i=0;
   /*for(;i < n; i++){
        cout<<i+1<<"\t";
        cin>>arr[i];
   }*/
   sort(arr,arr+n);
   cout<<"Majority Element : "<<arr[n/2]<<endl;
   for(i=0;i < n; i++){
        cout<<arr[i]<<endl;
   }
}
