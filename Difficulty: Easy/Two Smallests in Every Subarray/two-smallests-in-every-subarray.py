class Solution:
    def pairWithMaxSum(self, arr):
        #code here
        n=len(arr)
        ans=0
        for i in range(1,n):
            ans=max(ans,arr[i]+arr[i-1])
        return ans if ans else -1

#{ 
 # Driver Code Starts
if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().strip().split("\n")

    t = int(data[0])
    lines = data[1:]

    for line in lines:
        s = list(map(int, line.strip().split()))
        solution = Solution()
        res = solution.pairWithMaxSum(s)
        print(res)

# } Driver Code Ends