def solution(stones, k):
    start,end = 1,200000000
    
    while start<=end:
        mid,cnt=(start+end)//2,0
        for s in stones:
            if s <= mid: cnt+=1
            else: cnt=0
            if cnt==k: break
        
        if cnt==k: end=mid-1
        else: start=mid+1 
    
    return start