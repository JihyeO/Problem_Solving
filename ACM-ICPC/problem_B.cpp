//
//  solve again in my style
//  ACM-ICPC B
//
//  Created by 오지혜 on 08/10/2019.
//  Copyright © 2019 오지혜. All rights reserved.
//

#include <iostream>

long long balance[100002];
int n;

int main(int argc, const char * argv[]) {
    
    scanf("%d", &n);
    long long mul=1;
    
    //when we enumerate balance number, we can find rule.
    //the first two number has to start with 01 or 10.
    //based on 01___ or 10___, the possible number repeated every multiples of two.
    for(int i=1; i<=n; i++){
        if(i%2==0){
            balance[i]=balance[i-1];
        }
        else{
            //be careful here.
            //when the square of 2 becomes over long long range, it goes to zero.
            //so we have to use '%'
            mul=(mul*2)%16769023;
            balance[i]=mul;
        }
    }
    printf("%lld", balance[n]);
    
    return 0;
}

