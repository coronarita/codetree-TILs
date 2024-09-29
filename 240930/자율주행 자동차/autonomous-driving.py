n, m = map(int, input().split())
x, y, d = map(int, input().split())
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
grid = [list(map(int, input().split())) for _ in range(n)]
vis = [[0 for _ in range(m)] for _ in range(n)]

vis[x][y] = 1
turn = 0

while True:
    nd = (d-1)%4
    nx, ny = x + dx[nd], y + dy[nd]

    if not vis[nx][ny] and grid[nx][ny] == 0 :
        vis[nx][ny] =1
        x, y, d = nx, ny, nd
        turn = 0
    else :
        if turn != 4 :
            d = nd
            turn += 1
        
        else : 
            d ^= 2
            nx, ny = x + dx[d], y + dy[d]
            if grid[nx][ny] == 1 : 
                break
            else : 
                d^= 2
                x, y = nx, ny
                turn=0
ans = sum(
    vis[x][y]
    for x in range(n)
    for y in range(m)
    if vis[x][y]
)
print(ans)