import heapq
def solution(n, works):
    if sum(works)<=n:
        return 0
    works=[w*-1 for w in works]
    heapq.heapify(works)
    while n>0:
        work=heapq.heappop(works)
        work,n=work+1,n-1
        heapq.heappush(works,work)
    
    ans=0
    for w in works:
        ans+=w**2
    return ans