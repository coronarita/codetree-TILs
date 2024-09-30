R, C, K = map(int, input().split())
# (c_i, d_i)의 정보
gol_list = [tuple(map(int, input().split())) for _ in range(K)]
grid = [[0 for _ in range(C+1)] for _ in range(R+1)]
vis = [[0 for _ in range(C+1)] for _ in range(R+1)]
def pr(arr=grid):
    for _ in range(1, R+1):
        print(*arr[_][1:])
    print()
# 방향 정의 : 북 동 남 서
dxs = [-1, 0, 1, 0]
dys = [0, 1, 0, -1]
# pr()
def in_range(x, y):
    # 진입 시에는 북쪽이 입장 가능하기 때문에 범위내로 처리합니다.
    return -1<=x<=R and 0<y<=C
def in_range_fin(x, y):
    return 0<x<=R and 0<y<=C
ans = []
# 가독성
SOUTH=2
EAST=1
WEST=3


def is_empty(row, col, d):
    # 3개의 전진방향 좌표에 대해 비어있는지, 격자 내인지 검사 후 반환
    # 전진 방향의 좌표
    ld, rd = (d-1)%4, (d+1)%4
    d_list = [ld, d, rd]

    for dd in d_list:
        # 인접 좌표들
        nr, nc = row + dxs[dd], col + dys[dd]
        # 인접 좌표에서 d방향으로 한칸 전진
        nr += dxs[d]
        nc += dys[d]
        if not in_range(nr, nc) or grid[nr][nc] > 0 :
            return False
    return True


def clear_grid():
    for i in range(R+1):
        for j in range(C+1):
            grid[i][j] = 0


def exit_adjacent(row, col, e_d):

    # 출구
    er, ec = row + dxs[e_d], col + dys[e_d]

    # 인접하다? - 출구 (er, ec) 4방향 중 1방향의 grid가 1인지?
    ld, rd = (e_d - 1) % 4, (e_d + 1) % 4
    d_list = [ld, e_d, rd]

    for dd in d_list:
        # 인접 좌표들
        nr, nc = row + dxs[dd], col + dys[dd]
        if not in_range(nr, nc) or grid[nr][nc] > 0:
            return True

    return False



def bfs(x, y):
    bot_row = 0

    from collections import deque
    # grid[x][y] == 1인 값들에 대해 방문처리 - x가 R이 될 때까지
    q = deque()
    q.append((x, y))
    vis[x][y] = 1

    # bfs
    while q:
        x, y = q.popleft()
        if grid[x][y] == 3 : # Center
            for d in range(4):
                nx, ny = x+ dxs[d], y + dys[d]
                if not in_range_fin(nx, ny) : continue
                if grid[nx][ny] <= 0 : continue
                if vis[nx][ny] : continue
                if grid[nx][ny] == 2 : # 출구라면
                    # print(nx, ny)
                    vis[nx][ny] = 2
                    bot_row = max(bot_row, nx)
                    # '출구'일 때 건너갈 수 있음
                    if exit_adjacent(x, y, d):
                        q.append((nx, ny))
                else :
                    vis[nx][ny] = 1
                    bot_row = max(bot_row, nx)

        elif grid[x][y] == 1 : # 중앙이 아닌 일반 입구
            for d in range(4):
                nx, ny = x + dxs[d], y + dys[d]
                if not in_range_fin(nx, ny): continue
                if grid[nx][ny] <= 0: continue
                if vis[nx][ny]: continue
                if grid[nx][ny] == 3:  # 출구라면
                    vis[nx][ny] = 3
                    q.append((nx, ny))
                else:
                    vis[nx][ny] = grid[nx][ny]
                    bot_row = max(bot_row, nx)

        else : # 출구일 때
            for d in range(4):
                nx, ny = x+ dxs[d], y + dys[d]
                if not in_range_fin(nx, ny) : continue
                if grid[nx][ny] <= 0 : continue
                if vis[nx][ny] : continue
                vis[nx][ny] = grid[nx][ny]
                bot_row = max(bot_row, nx)
                q.append((nx, ny))


    return bot_row

def reset_vis():
    for i in range(R+1):
        for j in range(C+1):
            vis[i][j] = 0

cnt = 0
for gol in gol_list :
    cnt+=1
    # 골렘들을 이동 시킴 - 초기 골렘의 좌표는 0 (진입 전)
    row = 0
    col, e_d = gol
    reset_vis()
    while row <= R : # 전진할 수 있으면 전진해야됨
        # print(row, col, e_d)
        # 전진 검사 (row, col, e_d)
        # 1. 남쪽 3개의 좌표가 비어있으면 ?
        if is_empty(row, col, SOUTH) :
            # 전진합니다.
            row += 1
        # 2. 서쪽 방향으로 3개의 좌표 비어있으면 ?
        elif is_empty(row, col, WEST) and is_empty(row, col-1, SOUTH):
            # 출구를 반시계 회전하면서 내려갑니다.
            row += 1
            col -= 1
            e_d = (e_d-1)%4
        # 3. 동쪽 방향으로 3개 좌표 비어있으면 ?
        elif is_empty(row, col, EAST) and is_empty(row, col+1, SOUTH):
            row += 1
            col += 1
            e_d = (e_d+1)%4
        # 4. 전진할 수 없으면 좌표에 고정 처리 및
        # '전체 좌표'가 격자 내에 있는지 검사
        else :
            grid[row][col] = 3 # center

            # 4방향 검사 및 격자 내 골렘 위치 시키기
            is_clear = False
            for d in range(4):

                nr, nc = row + dxs[d], col + dys[d]
                if d == e_d:
                    grid[nr][nc] = 2
                else :
                    grid[nr][nc] = 1
                if not in_range_fin(nr, nc):
                # "격자 밖으로 골렘이 위치한 경우가 있다면"
                    is_clear = True
                    break

            # 격자를 초기화 후 다음 골렘을 진행
            if is_clear:
                clear_grid()
                break

            # 정령은 가장 남쪽으로 이동
            # 골렘의 "출구"가 "다른 골렘"과 인접하다면 정령의 이동 가능
            # 이동 후 row만큼 점수 획득
            elif exit_adjacent(row, col, e_d) :
                val = bfs(row, col)
                ans.append(val)
                break
            else :
                ans.append(row + 1)
                break
    # if cnt > 7:
    # pr(vis)
    # pr(grid)
    # print(ans)

# 정답 : 정령들의 최종 위치 총합
print(sum(ans))