def solution(land):

    for idx in range(1,len(land)):
        for jdx in range(len(land[0])):
            land[idx][jdx]+=max(land[idx-1][:jdx]+land[idx-1][jdx+1:])

    return max(land[-1])