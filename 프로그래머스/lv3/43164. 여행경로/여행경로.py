def solution(tickets):
    answer = []
    
    def dfs(ret,arr):
        nonlocal answer
        if len(arr)==0:
            answer.append(ret)
            return        
        for i in range(len(arr)):
            if ret[-1]==arr[i][0]:
                tmp=arr.copy()
                tmp.pop(i)
                dfs(ret+[arr[i][1]],tmp)
                
        
    dfs(["ICN"],tickets)
    answer.sort() 
    return answer[0]