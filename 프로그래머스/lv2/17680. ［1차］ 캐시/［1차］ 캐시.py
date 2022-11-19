from collections import deque
def solution(cacheSize, cities):
    ans=0
    cache=deque(maxlen=cacheSize)
    for c in cities:
        cl=c.lower()
        if cl in cache:
            cache.remove(cl)
            ans+=1
        else: 
            ans+=5
        cache.append(cl)
            
    return ans