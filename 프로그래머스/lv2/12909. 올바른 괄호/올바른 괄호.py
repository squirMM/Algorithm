def solution(s):
    ans = True
    
    stack=[]
    for i in s:
        if i=="(": stack.append("(") 
        else:
            if stack: stack.pop()
            else: ans=False
            
    if len(stack)!=0: ans=False
    return ans