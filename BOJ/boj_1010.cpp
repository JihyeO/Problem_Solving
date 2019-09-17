//BOJ_1010

#include <iostream>
#include <cstring>

int bridge[31][31];
int testcase;

int combination(int m, int n){
    if(m==n || n==0)
        return 1;
    if(bridge[m][n])
        return bridge[m][n];
    return bridge[m][n]=combination(m-1, n-1) + combination(m-1, n);
}

int main() {
    
    scanf("%d", &testcase);
    
    while(testcase--){
        memset(bridge, 0, sizeof(bridge));
        
        int n, m;
        
        scanf("%d %d", &n, &m);
        
        printf("%d\n", combination(m, n));
    }
    
}

