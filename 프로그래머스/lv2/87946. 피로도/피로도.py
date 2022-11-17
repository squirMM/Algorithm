def solution(k, dungeons):
    ans = -1
    
    visit=[False]*(len(dungeons))
    def bf(energy,cnt):
        nonlocal ans
        if False not in visit:
            ans=max(ans,cnt)
        for i,dun in enumerate(dungeons):
            if visit[i]: continue
            visit[i]=True
            if energy>=dun[0]:bf(energy-dun[1],cnt+1)
            else: bf(energy,cnt)
            visit[i]=False
    
    bf(k,0)
    return ans