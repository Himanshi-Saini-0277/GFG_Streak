//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

// User function Template for Java
class Trie {
    private class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }
    private TrieNode root;
    
    public Trie() {
        root=new TrieNode();    
    }

    public void insert(String word) {
        var curr=root;
        for(int k=0;k<word.length();k++){
            char c = word.charAt(k);
            int i=c-'a';
            if(curr.children[i]==null){
                curr.children[i]=new TrieNode();
            }
            
                curr=curr.children[i];
        }
        
        curr.isEnd=true;
    }

    public boolean search(String word) {
        
        var curr=root;
        for(int k=0;k<word.length();k++){
            char c = word.charAt(k);
            int i=c-'a';
            if(curr.children[i]==null) return false;
            curr=curr.children[i];
        }
        return curr.isEnd;
    }

    public boolean isPrefix(String word) {
        var curr=root;
        for(int k=0;k<word.length();k++){
            char c = word.charAt(k);
            int i=c-'a';
            if(curr.children[i]==null) return false;
            curr=curr.children[i];
        }
        return true;
    }
}


//{ Driver Code Starts.

public class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int q = sc.nextInt();
            sc.nextLine();
            List<Boolean> ans = new ArrayList<>();
            Trie ob = new Trie();

            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                if (i != q - 1) sc.nextLine();

                if (x == 1) {
                    ob.insert(s);
                } else if (x == 2) {
                    ans.add(ob.search(s));
                } else if (x == 3) {
                    ans.add(ob.isPrefix(s));
                }
            }

            for (Boolean result : ans) {
                System.out.print(result + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends