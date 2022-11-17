def solution(brown, yellow):
    total=brown+yellow
    for i in range(1,int(total**1/2)+1):
        if total%i==0:
            if (total//i-2)*(i-2)==yellow:
                return sorted([total//i,i],reverse=True)