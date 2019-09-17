//BOJ_13305

#include <stdio.h>

int N;

int main() {
    
    scanf("%d", &N);
    long long roadL[N];
    long long price[N];
    long long result[N];
    long long min=10000;
    
    for(int i=0; i<N-1; i++){
        scanf("%lld", &roadL[i]);
    }
    for(int j=0; j<N; j++ ){
        scanf("%lld", &price[j]);
        
    }
    
    result[0]=price[0]*roadL[0];
    min=price[0];
    for(int k=1; k<N-1; k++){
        if(min>price[k])
            min=price[k];
        result[k]=result[k-1]+min*roadL[k];
        }
    
    printf("%lld", result[N-2]);
        

    
    return 0;
}

