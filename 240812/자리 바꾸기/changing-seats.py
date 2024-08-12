# 자리 바꾸기 2024-08-12 13:47

# n개의 줄에 거쳐 I번째 줄에 I번 사람이 자리바꿈이 이뤄지는 동안 앉게되는 자리의 개수

N, K = map(int, input().split())
o_list = [i for i in range(N)]
p_list = [i for i in range(N)]
# 각자 몇 군데의 자리에 앉을 수 있는지를 구하는 프로그램 - 무한반복 시 초기상태로 돌아오게 됨 !
# 방문여부를 처리하기 위해서, n x n의 행렬을 정의
visited = [[False for _ in range(N)] for _ in range(N)]
rule = [tuple(map(int, input().split())) for _ in range(K)] # i분에는 prv, nxt번째 자리의 사람이 서로 바꿈

idx = 0
# 초기방문처리
for i in range(N):
    visited[i][i] = True

while True:

    # swap rule
    r_idx = idx % K
    a, b = rule[r_idx]
    
    # 몇번 사람 ? - a-1에 있는 사람
    a_num, b_num = p_list[a-1], p_list[b-1]
    p_list[a-1], p_list[b-1] = p_list[b-1], p_list[a-1]
    
    # 몇번 사람 - 어디에 갔는지
    visited[a_num][b-1] = True
    visited[b_num][a-1] = True
    # print(p_list)

    if o_list == p_list : 
        break
    idx += 1

for i in range(N):
    print(sum(visited[i]))