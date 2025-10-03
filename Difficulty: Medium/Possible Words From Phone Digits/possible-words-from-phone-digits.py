class Solution:
    def possibleWords(self, arr):
        # code here
        from itertools import product
        
        m = {k: v for k, v in zip(range(2, 10), ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"])}
        return ["".join(e) for e in product(*[m[e] for e in arr if e in m])]
        