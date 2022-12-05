import heapq
def solution(scoville, K):
    cnt = 0
    heapq.heapify(scoville)
    while scoville:
        fst=heapq.heappop(scoville)
        if fst>=K:
            break
        if len(scoville)==0:
            cnt=-1
            break
        sec=heapq.heappop(scoville)
        mix=fst+sec*2
        heapq.heappush(scoville,mix)
        cnt+=1
    return cnt