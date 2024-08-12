N, K = map(int, input().split())
rule = [tuple(map(lambda x: int(x) - 1, input().split())) for _ in range(K)]

# 비트마스킹을 위한 초기화
visited = [1 << i for i in range(N)]
position = list(range(N))

# 주기 계산
def calculate_cycle():
    
    cycle = 0
    while True:
        cycle += 1
        for a, b in rule:
            position[a], position[b] = position[b], position[a]
            visited[position[a]] |= 1 << a
            visited[position[b]] |= 1 << b
        if position == list(range(N)):
            return cycle

# 주기 계산
cycle = calculate_cycle()

# 남은 반복 처리
remaining = (N * K) % cycle
for _ in range(remaining):
    for a, b in rule:
        position[a], position[b] = position[b], position[a]
        visited[position[a]] |= 1 << a
        visited[position[b]] |= 1 << b

# 결과 출력
for v in visited:
    print(bin(v).count('1'))