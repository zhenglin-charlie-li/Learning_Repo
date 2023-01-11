#include<stdio.h>
int main(){
	int array[10]={1,20,-1,0,30,5,-10,-7,0,-5};
	int count=0;
	int i;
	for(i=0;i<9;i++){
		if(array[i]<0){
			array[i]=array[i+1];
			i--;
			count++;
		}
	}
	for(i=0;i<10-count;i++){
		printf("%d ",array[i]);
	}
} 

//int[] method(int arr[]){
//	int count=0;
//	int i;
//	for(i=0;i<9;i++){
//		if(array[i]<0){
//			array[i]=array[i+1];
//			i--;
//			count++;
//		}
//	}
//	return arr[10-count];
//}
