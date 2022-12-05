import math
def solution(progresses, speeds):
    days=[math.ceil((100-p)/s) for s,p in zip(speeds,progresses)]
    ans=[]
    cnt,prev=1,days[0]
    for i in range(1,len(days)):
        if prev<days[i]:
            ans.append(cnt)
            prev=days[i]
            cnt=1
        else: cnt+=1
    ans.append(cnt)
    return ans