class Solution {
    public static String caseSort(String str) {
        // code here
        int n=str.length();
        int small[]=new int[26];
        int large[]=new int[26];
        for(int i=0;i<n;i++)
        {
            char c=str.charAt(i);
            if(c>='A' && c<='Z')
            {
                int idx=c-'A';
                large[idx]+=1;
            }
            else
            {
                int idx=c-'a';
                small[idx]+=1;
            }
        }
        StringBuilder ans=new StringBuilder();
        int s=0;
        int l=0;
        for(int i=0;i<n;i++)
        {
            char c=str.charAt(i);
            if(c>='A' && c<='Z')
            {
                while(l<26 && large[l]==0)
                {
                    l++;
                }
                large[l]-=1;
                char ch=(char)(l+'A');
                ans.append(ch);
            }
            else
            {
                while(s<26 && small[s]==0)
                {
                    s++;
                }
                small[s]-=1;
                char ch=(char)(s+'a');
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}