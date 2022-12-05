def solution(m, n, puddles):
    load=[[0]*n for _ in range(m)]
    load[0][0]=1

    for y in range(m):
        for x in range(n):
            if (x==0 and y==0) or [y+1,x+1] in puddles: continue
                             
            if y==0 or [y,x+1] in puddles :
                load[y][x]=load[y][x-1]
            elif x==0 or [y+1,x] in puddles: 
                load[y][x]=load[y-1][x]
            else:
                load[y][x]=load[y][x-1]+load[y-1][x]
                
    return load[-1][-1]%1000000007