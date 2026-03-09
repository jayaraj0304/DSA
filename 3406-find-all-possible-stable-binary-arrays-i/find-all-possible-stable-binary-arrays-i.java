class Solution {
    static final long MOD = 1000000007;

    long power(long a,long b){
        long res=1;
        a%=MOD;
        while(b>0){
            if((b&1)==1) res=(res*a)%MOD;
            a=(a*a)%MOD;
            b>>=1;
        }
        return res;
    }

    public int numberOfStableArrays(int zero,int one,int limit){

        int maxN=zero+one;

        long[] fact=new long[maxN+1];
        long[] invFact=new long[maxN+1];

        fact[0]=1;
        for(int i=1;i<=maxN;i++)
            fact[i]=(fact[i-1]*i)%MOD;

        invFact[maxN]=power(fact[maxN],MOD-2);

        for(int i=maxN-1;i>=0;i--)
            invFact[i]=(invFact[i+1]*(i+1))%MOD;

        java.util.function.BiFunction<Integer,Integer,Long> C=(n,k)->{
            if(k<0||k>n) return 0L;
            return fact[n]*invFact[k]%MOD*invFact[n-k]%MOD;
        };

        java.util.function.Function<int[],Long> F=(arr)->{
            int N=arr[0],K=arr[1],L=arr[2];
            if(K<=0||K>N) return 0L;

            long ans=0;
            int maxJ=(N-K)/L;

            for(int j=0;j<=maxJ;j++){
                long term=C.apply(K,j)*C.apply(N-j*L-1,K-1)%MOD;
                if((j&1)==1) ans=(ans-term+MOD)%MOD;
                else ans=(ans+term)%MOD;
            }

            return ans;
        };

        int maxK=Math.min(zero,one+1);

        long[] fOne=new long[maxK+2];

        for(int k=1;k<=maxK+1;k++)
            fOne[k]=F.apply(new int[]{one,k,limit});

        long ans=0;

        for(int k=1;k<=maxK;k++){
            long fz=F.apply(new int[]{zero,k,limit});
            if(fz==0) continue;

            long fo=(fOne[k-1]+2*fOne[k]+fOne[k+1])%MOD;
            ans=(ans+fz*fo)%MOD;
        }

        return (int)ans;
    }
}