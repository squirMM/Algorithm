T = int(input())
for test_case in range(1, T + 1):
    N=int(input())
    arr=list(map(int,input().split()))
    ans=0

    while(True):
        if(len(arr)==0):break
        maxIdx=arr.index(max(arr))
        ans+=max(arr)*maxIdx-sum(arr[:maxIdx])
        arr=arr[maxIdx+1:]

    print(f'#{test_case} {ans}')