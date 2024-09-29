n = int(input())
nums=list(map(int, input().split()))
ops=list(map(int, input().split()))

maxi, mini = -1e8, 1e9

op_dict = {0:'+', 1:'-', 2:'*'}

# 정수 nums는 순서를 바꿀 수 없음
# 연산자 배치는 변경 가능 
# 1 5 3 => 1+5-3 = 3 , 1-5+3 = -1;
# 시간복잡도 : 11개 정수 : 10개의 연산자 칸
selected = []

def calc(selected):
    val = 0
    equ = ""
    for idx, num in enumerate(nums):
        if idx != n-1:
            equ += str(num)
            op = op_dict[selected[idx]]
            equ += op
        else : 
            equ += str(num)

    return eval(equ)

def backtracking(cnt:int) -> None:
    global maxi, mini
    # base cond
    if cnt == n-1 : 
        val = calc(selected)
        maxi, mini = max(maxi, val), min(mini, val)
        return
    
    for idx in range(len(ops)):
        if ops[idx] > 0 : 
            selected.append(idx)
            ops[idx] -= 1
            backtracking(cnt+1)
            selected.pop()
            ops[idx] += 1

# backtracking
backtracking(0) # 인수 : 선택 된 연산자의 수



print(mini, maxi)