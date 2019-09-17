//BOJ_1992

#include <stdio.h>

int N;
int tree[64][64];
int current;
bool check, exitbreakLoop;

void divide(int d, int s, int e){
    
    current=tree[s][e];
    check = true;
    exitbreakLoop = false;
    
    for(int i=s; i<s+d; i++){
        for(int j=e; j<e+d; j++){
            if(tree[i][j]!=current){
                check=false;
                exitbreakLoop=true;
                break;
            }
        }
        if(exitbreakLoop)
            break;
    }
    
    if(check){
        printf("%d", current);
    }
    else{
        printf("(");
        divide(d/2, s, e);
        divide(d/2, s, e+d/2);
        divide(d/2, s+d/2, e);
        divide(d/2, s+d/2, e+d/2);
        printf(")");
    }
}

int main() {
    
    scanf("%d", &N);
    
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            scanf("%1d", &tree[i][j]);
        }
    }
    divide(N, 0, 0);


}



