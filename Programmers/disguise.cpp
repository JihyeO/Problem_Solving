//
//  programmers_Disguise_위장
//
//  Created by 오지혜 on 09/10/2019.
//  Copyright © 2019 오지혜. All rights reserved.
//

#include <string>
#include <vector>
#include <map>

using namespace std;

//map<key, value>
map<string, int> classify;
map<string, int>::iterator iter;
int answer=1;

int solution(vector<vector<string>> clothes) {
    
    //using map, classify each clothes.
    for(int i=0; i<clothes.size(); i++){
        //map[key]=value
        classify[clothes[i][1]]++;
    }
    
    for(iter=classify.begin(); iter!=classify.end(); iter++){
        int tmp=0;
        //If there are more than two clothes in same category,
        //pick one of them. and plus 1 for not choosing. nC1 + 1
        if(iter->second>1){
            tmp=iter->second+1;
        }
        //else, there are two case, choose and not choose.
        else{
            tmp=2;
        }
        answer*=tmp;
    }
    
    //since we have to choose at least one.
    return answer-1;
}

