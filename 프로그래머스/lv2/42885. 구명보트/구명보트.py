from collections import deque

def solution(people, limit):
    ans=0
    q=deque(sorted(people))
    while q:
        if len(q)>1 and q[0]+q[-1]<=limit:
            q.popleft()
        q.pop()
        ans+=1
                
    return ans