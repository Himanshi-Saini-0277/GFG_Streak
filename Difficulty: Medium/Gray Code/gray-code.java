class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        
        for(int i = 0 ; i < (int)Math.pow(2 , n) ; i++){
            int xor = i ^ (i >> 1);
            String binStr = Integer.toBinaryString(xor);
            StringBuilder sb = new StringBuilder("");
            if(binStr.length() < n){
                for(int j = 1 ; j <= n - binStr.length() ; j++){
                    sb.append("0");
                }
            }
            sb.append(binStr);
            result.add(sb.toString());
        }
        return result;
    }
}