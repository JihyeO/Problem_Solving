#SW expert #1226

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for tc in range (1, 11):

    #get 
    T=int(input())
    board = [[0 for x in range(16)] for y in range(16)]
    check = [[False for x in range(16)] for y in range(16)]
    step=[]
    tmpX = 0
    tmpY = 0
    flag=False

    for i in range(16):
        getlist = str(input())
        for j in range(len(getlist)):
            value = int(getlist[j])
            board[i][j] = value
            #start point
            if value == 2:
                step.append([j, i])
    #BFS
    while step:
        current=step.pop(0)
        currentX=current[0]
        currentY=current[1]
        #visit mark
        check[currentY][currentX]=True
        #when arriving
        if board[currentY][currentX]==3:
                print("#%d 1"%T)
                flag=True
                break
        #up,down,left,right
        for a in range(4):
            tmpX = currentX+dx[a]
            tmpY = currentY+dy[a]
            if tmpX<0 or tmpX>=16 or tmpY<0 or tmpY>=16:
                continue
            #check near way firstly and add new spot
            if check[tmpY][tmpX] != True and board[tmpY][tmpX]!=1:
                step.append([tmpX, tmpY])
    if flag:
        flag=False
        continue
    else:
        print("#%d 0"%T)
 

