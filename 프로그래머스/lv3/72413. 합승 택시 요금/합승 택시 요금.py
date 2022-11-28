from math import inf

def solution(n, s, a, b, fares):
    s,a,b=s-1,a-1,b-1
    
    graph=[[inf]*n for _ in range(n)]
    for i in range(n):
        graph[i][i]=0

    for n1,n2,w in fares:
        graph[n1-1][n2-1]=graph[n2-1][n1-1]=w
    
    for k in range(n):          # 1. 모든 노드를 중간점(경로)으로 가정하면서
        for i in range(n):      # 2. 거리행렬을 순회
            for j in range(n):  # 3. 현재 거리행렬에 저장된 거리가 k를 거쳐가는 거리보다 멀면 갱신
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]
        
    ans = inf
    for k in range(n):
        ans = min(ans, graph[s][k] + graph[k][a] + graph[k][b])

    return ans