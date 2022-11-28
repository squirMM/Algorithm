def solution(n, words):
    stack=[words[0]]
    for i,w in enumerate(words):
        if i==0: continue
        if w in stack or words[i-1][-1]!=w[0]:
            return [i%n+1,i//n+1]
        stack.append(w)
    return [0,0]