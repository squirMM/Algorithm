from collections import deque
def solution(s):
    dq=deque(s)
    op,cl=['[','{','('],[']','}',')']
    ans=0
    for i in range(len(dq)):
        stack=deque()
        for d in dq:
            if d in op : stack.append(d)
            elif len(stack)>0:
                if cl[op.index(stack[-1])]!=d:
                    break
                else: stack.pop()
            else: break
        else: 
            if len(stack)==0: ans+=1
        dq.append(dq.popleft())
    return ans