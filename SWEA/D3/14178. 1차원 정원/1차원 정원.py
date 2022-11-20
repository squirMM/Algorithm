T = int(input())
for test_case in range(1, T + 1):
    N,D=map(int,input().split())
    def upperNum(N,length):
        if N%length>0:
            return int(N//length)+1
        return int(N//length)
    ans=upperNum(N,2*D+1)
    print(f'#{test_case} {ans}')