T = int(input())

for tc in range(T):
    testcase = int(input())
    score = list(map(int, input().split()))
    max = -1
    mode = 0

    scoreboard = [0 for x in range(0, 101)]

    #store the number of each score in scoreboard and distinguish mode
    for i in range(len(score)):
        scoreboard[score[i]]+=1
        if scoreboard[score[i]] == max:
            #select bigger score when the occurrences is same
            if score[i] > mode:
                mode = score[i]
        elif scoreboard[score[i]] > max:
            mode = score[i]
            max = scoreboard[score[i]]
    
    print("#%d %d"%(testcase,mode))

