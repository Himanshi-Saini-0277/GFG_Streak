#User function Template for python3
class Solution:

	# Function to find maximum
	# product subarray
	def maxProduct(self,a):
		# code here
		i, j = 0, 0
        n = len(a)
        prod = 1
        max_ = -float("inf")
        flag = False
        while j < n:
            if a[j] == 0:
                max_ = max(max_, 0)
            if a[j] != 0:
                prod *= a[j]
                max_ = max(max_, prod)
                j += 1
            else:
                while i < j-1:
                    prod = prod//a[i]
                    max_ = max(max_, prod)
                    i += 1
                j += 1
                i = j
                prod = 1
        while i < j-1:
            prod = prod//a[i]
            max_ = max(max_, prod)
            i += 1
        return max_

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.maxProduct(arr)
        print(ans)
        tc -= 1

# } Driver Code Ends