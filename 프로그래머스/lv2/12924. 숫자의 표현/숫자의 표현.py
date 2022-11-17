def solution(n):
    ans,total,s,e=1,1,1,1
    while e<n:
        if s>e: break
        if total>n:
            total-=s
            s+=1
        else:
            if total==n: ans+=1
            e+=1
            total+=e
    return ans