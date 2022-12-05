def solution(land):

    for idx in range(1,len(land)):
        for jdx in range(4):
            copy=land[idx-1].copy()
            del copy[jdx]
            land[idx][jdx]+=max(copy)

    return max(land[-1])