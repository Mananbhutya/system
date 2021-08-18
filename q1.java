import java.util.*;
class q1{
	int m[],w[],mp[][],wp[][];
	int n;
	public boolean pref(int m1,int m2,int woman){
		for(int i=1;i<=n;i++){
			if(wp[woman][i]==m1)return true;
			if(wp[woman][i]==m2)return false;
		}
		return false;
	}
	public void solve(){
		int free = n;
		while(free>0){
			int freeman=0;
			for(int i=1;i<=n;i++){
				if(m[i]==0){
					freeman=i;
					break;
				}
			}
			if(freeman==0)continue;
			for(int j=1;j<=n;j++){
				if(m[freeman]!=0)break;
				int woman = mp[freeman][j];
				if(w[woman]==0){
					m[freeman]=1;
					w[woman]=freeman;
					free--;
				}
				else{
					int second = w[woman];
					if(pref(freeman,second,woman)){
						m[freeman]=1;
						m[second]=0;
						w[woman]=freeman;
					}
				}
			}
		}
	}
	q1(){
        w = new int[1001];
        m = new int[1001];
        mp = new int [101][101];
        wp = new int[101][101];

        Scanner scan = new Scanner(System.in);         
        System.out.println("Enter number of men\n");
        n = scan.nextInt();


        for(int i = 1;i<=n;i++){
            System.out.printf("Enter preference list for man %d\n",i);
            for(int j = 1; j<=n;j++){
                mp[i][j]  = scan.nextInt();
            }
        }
        

        for(int i = 1;i<=n;i++){
            System.out.printf("Enter preference list for woman %d\n",i);
            for(int j = 1; j<=n;j++){
                wp[i][j]  = scan.nextInt();
            }
        }   
        solve();

        for(int i = 1 ; i<=n;i++){
            System.out.printf("%d:%d ",i,w[i]);
        }
        
    }
    public static void main(String[ ]args){
         new q1();

    }
}