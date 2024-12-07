//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int inversion(vector<int>&a,vector<int>&b){
        int count = 0;
        int i = 0 , j = 0;
        while(i<a.size() && j < b.size()){
            if(a[i]>b[j]){
                count += a.size() - i;
                j++;
            }
            else i++;
        }
        return count;
    }
    void merge(vector<int>&a,vector<int>&b,vector<int>&res){
        int i = 0, j = 0 , k = 0;
        while(i<a.size() && j<b.size()){
            if(a[i]<b[j]) res[k++] = a[i++];
            else res[k++] = b[j++];
        }
        if(i==a.size()) while(j<b.size()) res[k++] = b[j++];
        else while(i<a.size()) res[k++] = a[i++];
        return;
    }
    int mergesort(vector<int>&v){
        int n = v.size();
        int count = 0;
        if(n==1) return 0;
        int n1 = n/2 , n2 = n - n/2 ;
        vector<int>a(n1),b(n2);
        for(int i=0;i<n1;i++) a[i] = v[i];
        for(int i=0;i<n2;i++) b[i] = v[n1+i];
        count += mergesort(a);
        count += mergesort(b);
        count += inversion(a,b);
        merge(a,b,v);
        return count;
    }
    // Function to count inversions in the array.
    int inversionCount(vector<int> &arr) {
        // Your Code Here
        return mergesort(arr);
    }
};

//{ Driver Code Starts.

int main() {

    int T;
    cin >> T;
    cin.ignore();
    while (T--) {
        int n;
        vector<int> a;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int num;
        while (ss >> num)
            a.push_back(num);
        Solution obj;
        cout << obj.inversionCount(a) << endl;
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends