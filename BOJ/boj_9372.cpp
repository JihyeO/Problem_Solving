//
//  main.cpp
//  BOJ_9372


#include <iostream>
#include <stdio.h>
#include <string.h>

int testcase;
int N, M;
int country[1001][1001];
bool visited[1001];
int cnt, num;


void dfs(int v){
    
    visited[v]=true;
    cnt++;
    
    if(cnt==N){
        printf("%d\n", num);
        return;
    }
    
    for(int i=1; i<=N; i++){
        if(country[v][i]==1 && !visited[i]){
            num++;
            dfs(i);
        }
    }
    
}

int main() {
    
    scanf("%d", &testcase);
    
    while(testcase--){
        scanf("%d %d", &N, &M);
        
        for(int i=0; i<M; i++){
            int a, b;
            scanf("%d %d", &a, &b);
            country[a][b]=1;
            country[b][a]=1;
        }
        
        dfs(1);
        memset(visited, 0, sizeof(visited));
        memset(country, 0, sizeof(country));
        num=0;
        cnt=0;
    }
}





