def solution(routes):
    ans,w = 0,-30001
    routes.sort(key=lambda x:x[1])
    for i,o in routes:
        if i<=w:
            continue
        ans+=1
        w=o

    return ans