class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
       Set<Integer> set = new HashSet<>();
       for(int x : a) set.add(x);
       for(int x : b) set.add(x);
       for(int x : set) list.add(x);
       return list;
    }
}