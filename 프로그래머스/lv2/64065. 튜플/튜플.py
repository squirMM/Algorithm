import re
def solution(s):
    # print(re.findall("{[\d,]+}", s))
    s=s[2:-2].split("},{")
    arr=sorted([list(map(int,i.split(","))) for i in s],key=lambda x:len(x))

    ans = []
    for a in arr:
        diff=set(a)-set(ans)
        ans.append(list(diff)[0])

    return ans