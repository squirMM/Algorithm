import heapq

def solution(A, B):
    answer = 0
    A.sort(reverse=True)
    
    q=[n*-1 for n in B]
    heapq.heapify(q)
    
    for a in A:
        b=heapq.heappop(q)
        if a<b*-1:
            answer+=1
            continue
        heapq.heappush(q,b)
        
    return answer