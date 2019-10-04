#SW expert List 1 - electronic car

T=int(input())

for test_case in range(1, T + 1):
    K, N, M = map(int, input().split())
    power = list(map(int, input().split()))
    station = [0] * (N+1)

    for i in range(len(power)):
        station[power[i]] +=1

    s=0
    e=K
    result=0
    lose=0
    
    while True:
        for i in range(s+1, e+1):
            if station[i]==1:
                s=i
            else:
                lose+=1
        
        if lose==K:
            result=0
            break
        
        result+=1
        e=s+K
        lose=0

        if e>=N:
            break

    print('#%s %d' %(test_case, result))

