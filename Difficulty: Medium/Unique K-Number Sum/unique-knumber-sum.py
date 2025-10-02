class Solution:
    def combinationSum(self, n, k):
        # code here
        def gen(n, k, i=1, acc=[], ans=[]):
            if n == 0 and k == 0:
                ans.append(acc.copy())
                return ans
            if n < i or k < 0 or i > 9:
                return ans
            acc.append(i)
            gen(n - i, k - 1, i + 1)
            acc.pop()
            gen(n, k, i + 1)
            return ans
        
        return list(gen(n, k))
        