class Solution {
    public boolean divby13(String s) {
        // code here
        int digit = 0;
        int i=0;
        while(i<s.length()){
            digit = digit*10 + (s.charAt(i)-'0');
            digit = digit %13;
            i++;
        }
        return digit  == 0;
    }
}