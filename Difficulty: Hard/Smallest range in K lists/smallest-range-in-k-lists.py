class Solution:
    def findSmallestRange(self, arr):
        # code here
        kk=len(arr)
        if kk==1:
            return [arr[0][0],arr[0][0]]
        tmp=[]
        for k in range(kk):
            tmp.extend([(x,k,) for x in arr[k]])
        tmp.sort()
        ret=[]
        mn=float('inf')
        l=0
        lv=tmp[l][0]
        lk=tmp[l][1]
        cnt={lk:1}
        for r in range(1,len(tmp)):
            rv=tmp[r][0]
            rk=tmp[r][1]
            cnt[rk]=cnt.get(rk,0)+1
            while len(cnt)==kk:
                if rv-lv<mn:
                    mn=rv-lv
                    ret=[lv,rv]
                cnt[lk]-=1
                if cnt[lk]==0:
                    cnt.pop(lk)
                l+=1
                lv=tmp[l][0]
                lk=tmp[l][1]
        return ret


#{ 
 # Driver Code Starts
# Initial Template for Python 3

t = int(input())
for _ in range(t):
    n = int(input())
    k = int(input())
    arr = []
    for _ in range(k):
        arr.append(list(map(int, input().strip().split())))
    r = Solution().findSmallestRange(arr)
    print(r[0], r[1])
    print("~")

# } Driver Code Ends