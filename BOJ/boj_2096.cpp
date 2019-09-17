//BOJ_2096

#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int N;
int dp_max[2][3];
int dp_min[2][3];
int a, b, c;



int main() {
    
    scanf("%d", &N);
    
    
    
    for(int k=1; k<=N; k++){
        scanf("%d %d %d", &a, &b, &c);
        dp_max[1][0]=max(dp_max[0][0], dp_max[0][1]) + a;
        dp_max[1][1]=max(max(dp_max[0][0], dp_max[0][1]), dp_max[0][2]) + b;
        dp_max[1][2]=max(dp_max[0][1], dp_max[0][2]) + c;
        
        dp_min[1][0]=min(dp_min[0][0], dp_min[0][1]) + a;
        dp_min[1][1]=min(min(dp_min[0][0], dp_min[0][1]), dp_min[0][2]) + b;
        dp_min[1][2]=min(dp_min[0][1], dp_min[0][2]) + c;
        
        dp_max[0][0]=dp_max[1][0];
        dp_max[0][1]=dp_max[1][1];
        dp_max[0][2]=dp_max[1][2];
        
        dp_min[0][0]=dp_min[1][0];
        dp_min[0][1]=dp_min[1][1];
        dp_min[0][2]=dp_min[1][2];
 
    }

    printf("%d %d", max(max(dp_max[1][0], dp_max[1][1]), dp_max[1][2]),
           min(min(dp_min[1][0], dp_min[1][1]), dp_min[1][2]));
}

