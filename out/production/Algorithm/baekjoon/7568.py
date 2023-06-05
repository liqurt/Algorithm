
# 입력
N = int(input())
man =[[0 for col in range(2)] for row in range(N)]
for i in range(N):
    man[i][0], man[i][1]=map(int,input().split())
    
result = []
for i in range(N) :
    k = 0
    for j in range(N) :
        if((man[j][0] > man[i][0]) and (man[j][1] > man[i][1])) :
            k+=1
    rank = k+1
    result.append(str(rank))
print(' '.join(result))