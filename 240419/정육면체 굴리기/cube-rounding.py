'''
칸에 쓰여져 있는 수가 0이면, 주사위의 바닥면에 쓰여져있는 수가 칸에 복사됩니다. 이때 정육면체의 숫자는 변하지 않습니다.

칸에 쓰여져 있는 수가 0이 아니면 칸에 쓰여져있는 수가 정육면체 바닥면으로 복사되며, 해당 칸의 수는 0이 됩니다.

정육면체는 격자판 밖으로 이동할 수 없습니다. 만약 바깥으로 이동시키려고 하는 시도가 있을 때, 해당 시도를 무시하며 출력도 하지 않습니다.
'''

# 입력 받기
N, M, X, Y, K = tuple(map(int, input().split()))
BOARD = [list(map(int, input().split())) for _ in range(N)]
MOVE_DIRECTIONS = list(map(lambda x: int(x) - 1, input().split()))

TOP = 0
FRONT = 1
BOTTOM = 2
BACK = 3
LEFT = 4
RIGHT = 5

DICE = [0, 0, 0, 0, 0, 0]  # initialization

# 방향 : 동 서 북 남 (R L D U)
dxs, dys = [0, 0, -1, 1], [1, -1, 0, 0]


# x, y 좌표로 이동 가능한지 체크합니다.
def can_go(x, y):
    return 0 <= x < N and 0 <= y < M


# 주사위를 굴려서 업데이트 합니다.
def turn_dice(move_dir):
    # move_dir 방향에 따라서 업데이트 되는 DICE 면이 상이합니다.
    if move_dir == 0:  # 동쪽
        DICE[TOP], DICE[RIGHT], DICE[BOTTOM], DICE[LEFT] = DICE[LEFT], DICE[TOP], DICE[RIGHT], DICE[BOTTOM]
    elif move_dir == 1:  # 서쪽
        DICE[TOP], DICE[RIGHT], DICE[BOTTOM], DICE[LEFT] = DICE[RIGHT], DICE[BOTTOM], DICE[LEFT], DICE[TOP]
    elif move_dir == 2:  # 북쪽
        DICE[TOP], DICE[FRONT], DICE[BOTTOM], DICE[BACK] = DICE[FRONT], DICE[BOTTOM], DICE[BACK], DICE[TOP]
    else:  # 남쪽
        DICE[TOP], DICE[FRONT], DICE[BOTTOM], DICE[BACK] = DICE[BACK], DICE[TOP], DICE[FRONT], DICE[BOTTOM]


def update_board():
    if BOARD[X][Y]:  # 0이 아니면
        DICE[BOTTOM] = BOARD[X][Y]
        BOARD[X][Y] = 0
    else:  # 0이면
        BOARD[X][Y] = DICE[BOTTOM]


# 방향이 주어질 때 조건에 따라 수행
for move_dir in MOVE_DIRECTIONS:
    nx, ny = X + dxs[move_dir], Y + dys[move_dir]

    # 가지 못하면 수행하지 않습니다.
    if not can_go(nx, ny):
        continue

    # 위치를 업데이트합니다.
    X, Y = nx, ny
    turn_dice(move_dir)
    update_board()
    print(DICE[TOP])