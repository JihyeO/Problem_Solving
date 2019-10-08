//
//  programmers_42585_쇠막대기
//
//  Created by 오지혜 on 08/10/2019.
//  Copyright © 2019 오지혜. All rights reserved.
//
//나의 방법은 입력받으면서 (다음 )이 바로 나오면 레이저라고 인식하여 레이저 벡터에 담고,
//아닌경우는 (만 stack에 담으면서 )가 등장할 경우 pop하여 또 막대기 벡터에 담았다.
//그리고 레이저 벡터를 방문하면서 막대기 벡터를 가르는 경우들을 카운팅하여 잘린 막대기의 수를 세려고 했다.
//하지만 문제는 계산이 너무 많아지고 비효율적. 데이터 처리도 어려웠다.
//그냥 바로! 어차피 스택에는 (만 들어가 있을 것이므로 이것 자체가 막대기의 수다. 따라서 매번 스택에 담긴 수를 더해주면된다.

#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

string arrangement;
stack<char> stk;
vector<int> laser;
vector<pair<int, int>> stick;
int answer=0;

int main(int argc, const char * argv[]) {
    
    cin >> arrangement;
    
    for(int i=0; i<arrangement.length(); i++){
        if(arrangement[i]=='('){
            stk.push(arrangement[i]);
        }
        else{
            stk.pop();
            if(i>0&& arrangement[i-1]=='('){
                answer+=stk.size();
            }
            else{
                answer++;
            }
        }
    }

    printf("%d", answer);
    
    return 0;
}

