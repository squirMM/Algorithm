from collections import Counter
def solution(gems):
    answer=[]
    num=len(set(gems))
    
    #길이가 보장되지 않을땐 이중포인터 사용 
    l=0
    counter=Counter()
    for r in range(len(gems)):
        # gems[r] 추가
        counter[gems[r]]+=1
        # 종류가 맞게 나오는지
        while len(counter) == num:
            if l>r: break
            # l 움직이기 
            counter[gems[l]] -= 1
            # 만약 0값이면 삭제 필요
            if counter[gems[l]] == 0:
                del counter[gems[l]]
            l += 1
            answer.append([l, r+1])
             
    answer.sort(key=lambda x: (x[1]-x[0],x[0]))
    return answer[0]