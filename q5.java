import java.util.*;
class q5{
    public int partition(int arr[],int low,int hi){
        int i=low-1;
	int j=0;
	int pivot = arr[hi-1];
	for(j=low;j<hi-1;j++){
		if(arr[j]<pivot){
			i++;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	for(j=hi-1;j>i+1;j--){
		arr[j] = arr[j-1];
	}
	arr[i+1] = pivot;
	return i+1;
    }
    public void quicksort(int arr[],int low,int hi){
        if((hi-low)<=1){return;}
	int pivot = partition(arr,low,hi);
	quicksort(arr,low,pivot);
	quicksort(arr,pivot+1,hi);
    }
    q5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = (int)(Math.random()*10+1);
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        long start = System.nanoTime();
        quicksort(arr,0,n);
        long end = System.nanoTime();
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("Time = "+(end-start));
        sc.close();
    }
    public static void main(String[] args) {
        new q5();
    }
}
