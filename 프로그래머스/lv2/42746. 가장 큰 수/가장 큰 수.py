def solution(numbers):
    nums=list(map(str,numbers))
    nums.sort(key=lambda x:x*3, reverse=True)
    answer = str(int("".join(nums)))
    return answer