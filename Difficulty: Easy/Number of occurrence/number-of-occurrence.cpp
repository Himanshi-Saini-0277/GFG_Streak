//{ Driver Code Starts
// Initial function template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
    int Binary_search_left(vector<int>& arr, int &key,int &n){
        
        int st = 0 ;
        int end = n - 1 ;
        int mid = end - ( end - st)/2;
        int ans = 0;
        while(st <= end){
            
            if(arr[mid]==key){
                ans = mid;
                end = mid-1;
            }
            else if(arr[mid] > key){
                end = mid - 1 ;
            }
            else st = mid + 1 ;
            mid = end - ( end - st)/2;
        }
        if(arr[ans]==key) return ans;
        else return -1;
    }
    
   int Binary_search_right(vector<int>& arr, int &key,int &n){
        
        int st = 0 ;
        int end = n - 1 ;
        int mid = end - ( end - st)/2;
        int ans = 0;
        while(st <= end){
            
            if(arr[mid]==key){
                
                ans = mid;
                st = mid+1;
            }
            else if(arr[mid] > key){
                end = mid -1 ;
            }
            else st = mid + 1 ;
            mid = end - ( end - st)/2;
        }
        if(arr[ans]==key) return ans;
        else return -1;
    }
  public:
    int countFreq(vector<int>& arr, int target) {
        
        int n = arr.size();
        
        int left_index = Binary_search_left(arr,target,n);
        int right_index = Binary_search_right(arr,target,n);
        
        if(left_index==-1 || right_index==-1) return 0;
        else return right_index - left_index + 1 ;
        
    }
};


//{ Driver Code Starts.

int main() {
    int test_case;
    cin >> test_case;
    cin.ignore();
    while (test_case--) {

        int d;
        vector<int> arr, brr, crr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        getline(cin, input);
        ss.clear();
        ss.str(input);
        while (ss >> number) {
            crr.push_back(number);
        }
        d = crr[0];
        int n = arr.size();
        Solution ob;
        int ans = ob.countFreq(arr, d);
        cout << ans << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends