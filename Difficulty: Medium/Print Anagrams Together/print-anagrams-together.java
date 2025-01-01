//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] strs) {
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        for(String i:strs){
            char [] arr=i.toCharArray();
            Arrays.sort(arr);
            String news=new String(arr);
            map.put(news,new ArrayList<String>());
        }
        for(String str:strs){
            char [] arr=str.toCharArray();
            Arrays.sort(arr);
            String news=new String(arr);
            if(map.containsKey(news)){
                map.get(news).add(str);
            }
        }
        ArrayList<ArrayList<String>> list=new ArrayList<>();
        for(String key:map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends