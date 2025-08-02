public class FIND_MINIMUM_LOG_TRANSPORTATION_COST {

    public static void main(String[] args) {
       System.out.println(minCuttingCost(6,5,5));
    }
    public static long minCuttingCost(int n, int m, int k) {
        long n1 = n/k;
        long m1 = m/k;

        long n2 = n%k;
        long m2 = m%k;

        long final_cost = 0;
        if(n1 != 0){
            int n3 = 1;
            if(n1==1 && n<=k) n3=0;
            if(n2==0) n2=1;
            final_cost = (long) (final_cost + Math.pow(k,n1)*n2*n3);
        }
        if(m1 != 0){
            int m3 = 1;
            if(m1==1 && m<=k) m3=0;
            if(m2 == 0) m2=1;
            final_cost = (long) (final_cost + Math.pow(k,m1)*m2*m3);
        }

        return final_cost;

    }
}