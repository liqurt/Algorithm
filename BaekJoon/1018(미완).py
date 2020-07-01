#입력 (N이 row, M이 col)
N, M = map(int,input().split())
board =[[0 for col in range(M)] for row in range(N)]
for i in range(N):
    board[i]=list(str(input()))

# 8by8 cliping
clipSize = 2
newBoard = [[-1 for col in range(clipSize)] for row in range(clipSize)]

col=0
row=0
while(row<N-clipSize+1):
    col=0
    while(col<M-clipSize+1):
        print(col,row,board[row][col],end=' ',sep='')
        col+=1
    print("")
    row+=1