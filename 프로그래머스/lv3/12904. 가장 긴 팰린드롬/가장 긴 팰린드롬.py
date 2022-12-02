def solution(s):
    answer = 0
    for ll in range(len(s),0,-1):
        if answer!=0: break
        for i in range(len(s)-ll+1):
            ss=s[i:i+ll]
            ssa,ssb="",""
            if ll%2==0: ssa,ssb=ss[:ll//2],ss[ll//2:]
            else: ssa,ssb=ss[:ll//2],ss[ll//2+1:]
            for s1,s2 in zip(ssa,ssb[::-1]):
                if s1!=s2: break
            else:
                answer=len(ss)
                break
        
    return answer