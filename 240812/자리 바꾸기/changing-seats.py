N, K = map(int, input().split())

# 자리 바꾸기 규칙
rule = [tuple(map(int, input().split())) for _ in range(K)]

# 각 사람의 방문한 자리를 기록할 리스트
visited = [set() for _ in range(N)]
p_list = list(range(N))  # 현재 자리 상태

# 초기 방문 기록 (자기 자리)
for i in range(N):
    visited[i].add(i)

# 주기 계산을 위한 변수
start_state = list(range(N))
idx = 0

while True:
    # 현재 자리 바꾸기 규칙 적용
    a, b = rule[idx % K]
    p_list[a-1], p_list[b-1] = p_list[b-1], p_list[a-1]

    # 방문한 자리 기록
    visited[p_list[a-1]].add(a-1)
    visited[p_list[b-1]].add(b-1)

    idx += 1

    # 주기가 반복되면 종료
    if p_list == start_state:
        break

# 각 사람이 방문한 자리의 개수 출력
for v in visited:
    print(len(v))