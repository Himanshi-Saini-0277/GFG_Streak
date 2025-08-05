class Solution {
    public boolean isPalinSent(String s) {
        // code here
        int l=0,r=s.length()-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(r>l && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l++))!=Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true;
    }
}