import java.util.*;
class q4{
	public void merge(int arr[],int l,int m,int r){
		int left[] = Arrays.copyOfRange(arr,l,m);
		int right[] = Arrays.copyOfRange(arr,m,r);
		int i=0,j=0,k=l;
		while(i!=(m-l)&&j!=(r-m)){
			if(left[i]<=right[j])arr[k++]=left[i++];
			else{
				arr[k++]=right[j++];
			}
		}
		while(i!=(m-l))arr[k++]=left[i++];
		while(j!=(r-m))arr[k++]=right[j++];
	}
	public void mergesort(int arr[],int l,int r){
		if(r-l==1)return;
		int m = l+(r-l)/2;
		mergesort(arr,l,m);
		mergesort(arr,m,r);
		merge(arr,l,m,r);
	}
	q4(){	
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[n];
		Random r = new Random();
		for(int i=0;i<n;i++){
			arr[i] = r.nextInt(1000);
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		mergesort(arr,0,n);
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args){new q4();}
}