//BOJ_9455

#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;

int T;
int m, n;
stack <int> s;
int cnt;
int result;


int main() {
    
    scanf("%d", &T);
    
    while(T--){
        scanf("%d %d", &m, &n);
        int box[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                scanf("%d", &box[i][j]);
            }
        }
        for(int i=0; i<n; i++){
            cnt=0;
            for(int j=m-1; j>=0; j--){
                if(box[j][i]){
                    box[j][i]=m-1-j-cnt;
                    result+=box[j][i];
                    cnt++;
                }
            }
        }
        printf("%d\n", result);
        result=0;
        
        
    }
    
}

