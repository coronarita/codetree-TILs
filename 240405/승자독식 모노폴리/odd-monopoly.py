'''
승자독식 모노폴리
20240405 14:55 -

'''

# n x n 격자에서
# m개의 플레이어

# Input
n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
temp = [[0] * n for _ in range(n)]
monopolied = [[{} for _ in range(n)] for _ in range(n)]
ans = 0
def pr(arr=grid):
    for _ in range(len(arr)):
        print(*arr[_])

NUM_DIR = 4
dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1] # 상하좌우
cur_dirs = [None] + list(map(lambda x: int(x)-1, input().split()))
# print(cur_dirs)
# pr()
# 방향 우선순위를 할당 할 자료구조 정의
dir_priority = [None]+ [
    [
        [
            -1 for _ in range(NUM_DIR)
        ] for _ in range(NUM_DIR)
    ] for _ in range(m)
]

# 방향 우선순위를 각 플레이어 별로 할당한다.
def input_priority():
    # m명의 플레이어
    for p_idx in range(1, m+1):
        for cur_dir in range(NUM_DIR):
            given_row = list(map(lambda x: int(x)-1, input().split()))
            for idx, next_dir in enumerate(given_row):
                dir_priority[p_idx][cur_dir][idx] = next_dir

    # 독점 여부 표기
    for i in range(n):
        for j in range(n):
            if grid[i][j] != 0 :
                monopolied[i][j][grid[i][j]] = k

def end():
    # 종료조건 : 1번 플레이어만 살아남는 턴의 수
    if ans >= 1000 :
        return True

    # 격자 내 1번 플레이어만 남아있는 지 탐색
    for i in range(n):
        for j in range(n):
            if grid[i][j] != 0 and grid[i][j] != 1 :
                return False

    return True


def init():
    for i in range(n):
        for j in range(n):
            temp[i][j] = 0

def update():
    for i in range(n):
        for j in range(n):
            grid[i][j] = temp[i][j]

    # 이동 후 각 플레이어들은 해당 칸 '독점'
    #   2. 독점 - k만큼의 턴 동안 유효



def in_range(x, y):
    return 0<=x and 0<=y and x<n and y<n


# x, y 에 사람이 있으면 -1, 없으면 False, 본인이면 본인의 수 반환
def is_monopolied(x, y, pnum):
    if len(monopolied[x][y]) == 0:
        return 0

    if monopolied[x][y].get(pnum) == None : # 사람이 있는데 None ?
        return -1
    else :
        return pnum

def move(x, y):
    # 1. 각 플레이어들은 한 칸씩 '이동'
    p_num = grid[x][y]
    cur_d = cur_dirs[p_num]

    #   - 본인에게 인접한 상하좌우 4칸 중
    #        - 이 때, '우선순위'에 따라 결정한다.
    #        - 보고있는 방향은 '직전의 이동방향'이다.
    for next_d in dir_priority[p_num][cur_d] :
        nx, ny = x + dxs[next_d], y + dys[next_d]
        if not in_range(nx, ny): continue
        # '아무도 독점계약이 없는 칸' 으로 이동
        state = is_monopolied(nx, ny, p_num)
        if state == 0 :
            #   4. 모든 플레이어의 이동 후, '한칸에 여러 플레이어가 있을 경우',
            #       - 작은 번호를 가진 플레이어 생존
            # 아무도 없다면
            if temp[nx][ny] == 0 :
                temp[nx][ny] = p_num
                break
            else : # 마주친다면
                if temp[nx][ny] > p_num :
                    temp[nx][ny] = p_num
                    break
                else :
                    # 이동하지 못했다. - 사라짐
                    break
                    # continue
    #   - 없을 경우 '본인이 독점계약 한 땅'으로 이동
    else:
        print("All monopolied")
        for next_d in dir_priority[p_num][cur_d]:
            nx, ny = x + dxs[next_d], y + dys[next_d]
            if not in_range(nx, ny): continue
            state = is_monopolied(nx, ny, p_num)
            if state == p_num : # 내가 독점 중임
                temp[nx][ny] = p_num
                break

def simulate():
    global k
    init()

    for x in range(n):
        for y in range(n):
            if grid[x][y] > 0 :
                move(x, y)

    for x in range(n):
        for y in range(n):
            if temp[x][y] > 0:
                monopolied[x][y][temp[x][y]] = k + 1

    update()


    # 턴 경과에 따른 독점영역 감소 처리
    for x in range(n):
        for y in range(n):
            if monopolied[x][y] :
                p, l_t = -1, -1
                for k, v in monopolied[x][y].items():
                    if v != 0 :
                        monopolied[x][y][k] -= 1
                        p, l_t = k, v

                if v == 0:
                    del monopolied[x][y][k]



    # pr(monopolied)


input_priority()
# 턴이 '진행'
while not end():
    ans += 1
    simulate()
    # print("turn", ans)
    # pr()
    # break

if ans >= 1000 :
    ans = -1
print(ans)