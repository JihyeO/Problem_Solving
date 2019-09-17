//BOJ_1038

#include <cstdio>
#include <math.h>

int N;
int digit, target;
int num, share, pre_remainder, current_remainder;
int jump;
bool ifbreak;

int main() {
    
    scanf("%d", &N);
    
    if(N>1022){
        printf("-1");
        return 0;
    }
    else if(N==1022){
        printf("9876543210");
    }
    else{
        while(true){
            pre_remainder=-1;
            ifbreak=false;
            num=digit;
            jump=1;
            
            while(num!=0){
                if(pre_remainder>=num%10){
                    ifbreak=true;
                }
                if (ifbreak && pre_remainder < num%10) {
                    break;
                }
                jump*=10;
                pre_remainder=num%10;
                num/=10;
            }
            
            if(ifbreak==false){
                if(target++==N)
                    break;
                digit++;
            }
            else{
                jump/=10;
                digit+=jump;
                digit=digit/jump*jump;
                continue;
            }
        }
        printf("%d", digit);
    }
}




