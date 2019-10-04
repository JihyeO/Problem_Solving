T = int(input())

#DP using iteration
paper=[0 for x in range(301)]
paper[10]=1
paper[20]=3


for tc in range(1, T+1):
    N = int(input())
    for n in range(30, N+1, 10):
        #the possible shapes as the last
        #we can fill the paper when using 10*20 or 20*10+20*10 or 20*20
        #and when we expend the paper, we can refer previous shape and add possible shape
        paper[n]=paper[n-10]+paper[n-20]*2
    print("#%d %d" %(tc, paper[N]))


