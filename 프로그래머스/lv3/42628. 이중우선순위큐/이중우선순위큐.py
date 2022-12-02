import heapq
def solution(operations):
    answer = [0,0]
    q=[]
    prev=-1
    for op in operations:
        com,num=op.split()
        if com=="I":
            heapq.heappush(q,int(num)*prev*-1)
        if q and com=="D":
            if prev!=int(num):
                heapq.heapify(q:=[-n for n in q])
                prev=int(num)
            heapq.heappop(q)
                
    if q:
        if prev==-1: answer=[max(q),min(q)]
        else : answer=[-1*min(q),-1*max(q)]
    return answer