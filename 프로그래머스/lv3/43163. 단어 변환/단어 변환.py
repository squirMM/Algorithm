def solution(begin, target, words):
    if target not in words:
        return 0
    
    def diff(s1,s2):
        cnt=0
        for a,b in zip(s1,s2):
            if a!=b: cnt+=1
        if cnt==1:
            return True
        return False
    ans=50
    def dfs(s,arr,cnt):
        nonlocal ans
        print(s)
        if s==target:
            ans=min(cnt,ans)
            return
        for i in range(len(arr)):
            if diff(s,arr[i]):
                tmp=arr.copy()
                tmp.pop(i)
                dfs(arr[i],tmp,cnt+1)
    
    dfs(begin,words,0)
    return ans