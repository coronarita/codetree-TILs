n = int(input())
works = []

# 외주수익 최대화 (t, p), (idx+1)일차 
# 2 5 / 2 7 / 1 3
# 0 - 2 / 5
# 1 - 3 / 7
# 2 - 3 / 3

for s in range(n):
    t, p = map(int, input().split())
    e = s + t
    works.append((s, e, p, t))

works.sort(key=lambda x:(-x[2], x[3], x[0]))
ans = 0

plans = [0] * n
for work in works : 
    s, e, p, t = work
    # 일이 가능한지 판단
    if not all(plans[s:e]) :
        for i in range(s, e):
            plans[i] = 1
        ans += p

# print(plans)
print(ans)