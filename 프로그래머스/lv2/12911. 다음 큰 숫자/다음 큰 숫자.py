from collections import Counter
def solution(n):
    bin1=Counter(format(n,'b'))['1']
    for num in range(n+1,1000000):
        if Counter(format(num,'b'))['1']==bin1:
            return num
    else:
        return num