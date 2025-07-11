class Solution {
    public int countConsec(int n) {
        // code here
        if(n < 2) return 0;
        
        int a = 1, b = 1;
        
        for( int i=2; i<= n; i++){
            int newA = a + b;
            int newB = a;
            a = newA;
            b = newB;
        }
        
        int total = 1 << n;
        int withoutConsec = a + b;
        
        return total - withoutConsec;
    }
}
