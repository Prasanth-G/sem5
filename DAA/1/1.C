#include<iostream>
#include<algorithm>
using namespace std;

int main(){
   int n = 10;
   //cout<<"Size of the array : ";
   //cin>>n;
   //int arr[10] = {2,3,1,6,5,4,9,8,2,7};
   int arr[10] = {1,3,5,7,9,11,13,15,17,19};
   int i=0;
   /*for(;i < n; i++){
        cout<<i+1<<"\t";
        cin>>arr[i];
   }*/
   int temp;
   int last = n-1;
   for(i=0;true; i++){
       if(arr[i] % 2 != 0){
           while(arr[last]%2 != 0){
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
        cout<<arr[i]<<endl;
   }
}
