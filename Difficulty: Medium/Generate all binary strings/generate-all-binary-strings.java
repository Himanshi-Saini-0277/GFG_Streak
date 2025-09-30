class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        int total = 1<<n;
        for(int  i=0; i<total; i++){
            StringBuilder res =new StringBuilder();
            for(int j=n-1; j>=0;j--){
                
                if((i & (1 << j)) != 0){
                    res.append("1");
                }else{
                    res.append("0");
                }
                 
            }
            list.add(res.toString());
        }
        return list;
    }
}
