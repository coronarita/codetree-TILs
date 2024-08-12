# virus exp : 240812 15:09
import heapq

# initial cond
# badge size, virus num, cycle_num : n, m, k
n, m, k = tuple(map(int, input().split()))
# init feeding
feeding = [[5 for _ in range(n)] for _ in range(n)]
add_feeding = [list(map(int, input().split())) for _ in range(n)]
# viruses - (r, c, age of virus)
virus_map = [ # heapq
    [
    [] for _ in range(n)]
    for _ in range(n)
]
virus_list = [tuple(map(int, input().split())) for _ in range(m)]

for virus in virus_list:
    r, c, age = virus
    heapq.heappush(virus_map[r-1][c-1], age)

def pr(arr=feeding):
    for _ in range(n):
        print(*arr[_])
    print()

def consume():

    temp_map = [ # heapq
    [
    [] for _ in range(n)]
    for _ in range(n)
]
    dead_list = [
    [
    [] for _ in range(n)]
    for _ in range(n)
]
    # 각 바이러스들은 양분을 섭취합니다.
    for r in range(n):
        for c in range(n):
            if len(virus_map[r][c]) == 0 :
                continue

            for virus_age in virus_map[r][c] :

                # 양분 섭취를 진행합니다.
                if virus_age > feeding[r][c]: # feeding이 부족하면 바로 죽음
                    dead_list[r][c].append(virus_age)
                else :
                    feeding[r][c] -= virus_age
                    virus_age += 1
                    heapq.heappush(temp_map[r][c], virus_age)

    # pr(feeding)
    # pr(temp_map)

    # dead_list 를 feeding에 처리
    for r in range(n):
        for c in range(n):
            for dead_virus_age in dead_list[r][c]:
                # 죽게되는 바이러스는 양분으로 변함 - 다 하고나서 해야 됨
                feeding[r][c] +=  dead_virus_age // 2

    # pr(temp_map) # 여기서 번식 해야 됨
    temp_map = take_spread(temp_map)

    for r in range(n):
        for c in range(n):
            virus_map[r][c] = temp_map[r][c]

def take_spread(v_map):

    def in_range(r, c):
        return 0<=r and r<n and 0<=c and c<n

    adj_r = [-1, -1, -1, 0, 0, 1, 1, 1]
    adj_c = [-1, 0, 1, -1, 1, -1, 0, 1]

    # 번식 진행 - 5의 배수
    for r in range(n):
        for c in range(n):
            for virus_age in v_map[r][c]:
                if virus_age % 5 == 0 :

                    # 인접한 칸 8개에 나이 1인 바이러스가 생김
                    for i in range(8):
                        nr, nc = r + adj_r[i], c + adj_c[i]

                        if not in_range(nr, nc): continue
                        heapq.heappush(v_map[nr][nc], 1)
    return v_map
def add():
    for r in range(n):
        for c in range(n):
            feeding[r][c] += add_feeding[r][c]
def simulate():

    consume()
    add()
    # pr(feeding)
    # pr(virus_map)

for _ in range(k):
    simulate()

# survived

print(
    sum(
    [len(virus_map[i][j]) for i in range(n) for j in range(n)]
)
)