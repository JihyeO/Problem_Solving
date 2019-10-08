//
//  main.cpp
//  ProblemH
//
//  Created by 오지혜 on 05/10/2019.
//  Copyright © 2019 오지혜. All rights reserved.
//

#include <iostream>
#include <cstdio>
#include <cmath>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    int n;
    scanf("%d", &n);
    
    int sum_of_square[50001];
    sum_of_square[0] = 0;
    sum_of_square[1] = 1;
    sum_of_square[2] = 2;
    sum_of_square[3] = 3;
    
    //start when number is 4
    int i=2;
    for(int num=4; num<=n; num++){
        //when number is a square number
        // num = j*j = 1, 4, 9, 16, ...
        if(num == i*i){
            i++;
            //it can be represented as only one number
            sum_of_square[num] = 1;
        }
        else{
            //to find minimum sum of square
            int pre_square = (i-1)*(i-1);
            int min_set = sum_of_square[num-pre_square];
            //to compare other possible minimum sum
            for(int j= i-2; j>0; j--){
                int pre2_square = j*j;
                int other_set = sum_of_square[num-pre2_square];
                min_set= min(min_set, other_set);
            }
            //1 means current square number
            //ex. 26=5^2+1^2 -> 5, and we had to find the other thing using dp.
            sum_of_square[num] = 1 + min_set;
        }
    }
    printf("%d \n", sum_of_square[n]);
    
}

