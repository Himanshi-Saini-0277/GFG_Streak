class Solution {
    public int startStation(int[] gas, int[] cost) {
        // code here
        int tg = 0;
        int cg = 0;
        int idx = 0;
        
        for(int i = 0; i < gas.length; i ++) {
            tg += gas[i] - cost[i];
            cg += gas[i] - cost[i];
            if(cg < 0) {
                cg = 0;
                idx = i + 1;
            }
        }
        return tg >= 0 ? idx : -1;
    }
}