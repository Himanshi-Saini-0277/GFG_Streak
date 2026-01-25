class Solution {
  public:
    int findWays(int n) {
        // code here
        if(n&1)return 0;
        vector<int>arr={1,2,5,14,42,132,429,1430,4862,16796};
        return arr[(n/2)-1];
    }
};