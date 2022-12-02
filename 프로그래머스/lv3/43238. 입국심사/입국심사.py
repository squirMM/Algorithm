def solution(n, times):
    start,end=1,max(times)*n
    while start<end:
        mid=(start+end)//2
        total=sum([mid//t for t in times])
        if total>=n:
            end=mid
        else:
            start=mid+1
    return end