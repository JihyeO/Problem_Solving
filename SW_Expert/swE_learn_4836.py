#SW expert LIST 2 coloring


T = int(input())


for tc in range (1, T+1):
    grid = [[0 for x in range(10)] for y in range(10)]
    cnt =0
    num = int(input())
    for n in range (num):
        r1, c1, r2, c2, color = map(int, input().split())
        for i in range (r1, r2+1):
            for j in range (c1, c2+1): 
                    if grid[i][j] != 0:
                        cnt +=1
                    else:
                        grid[i][j]= color
    
    print("#%d %d"%(tc, cnt))


    


