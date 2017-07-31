#include<iostream>
#include<algorithm>
using namespace std;

int main(){
   int m,n;
   cout<<"Enter Initial number of sacks : ";
   cin>>n;
   cout<<"No of cobs in each sack ";
   int i,sum=0;
   for(i=0;i<n;i++){
       cin>>m;
       sum += m;
   }
   for(i = 1;sum > (i*(i+1))/2;i++);
   cout<<i;
   
}

