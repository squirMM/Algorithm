def solution(A, B):
    # 행렬 전환
    return [[sum(a*b for a,b in zip(A_row, B_col)) for B_col in zip(*B)] 
            for A_row in A]