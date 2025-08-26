class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int a = 0;
        int j =0;
        int n = s1.length();
        
        for(int i =0; i<s2.length(); i++ ){
          if(s1.charAt(j)==s2.charAt(i) ) {
              a++;
              j++;
          }
          if(j==n){
              break;
          }
        }
        
        if(a==s1.length()){
            return true;
        }else{
            return false;
        }
    }
};