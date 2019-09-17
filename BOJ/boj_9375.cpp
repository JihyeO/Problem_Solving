//
//  main.cpp
//  fashionking

#include <iostream>
#include <vector>
#include <map>

int testcase;
int n;
int ans;

using namespace std;

int main() {
    
    scanf("%d", &testcase);
    map<string, int> item;
    
    
    while(testcase--){
        scanf("%d", &n);
        for(int i=0; i<n; i++){
            char tmp[21], tmp2[21];
            scanf("%s %s", tmp, tmp2);
            item[tmp2]++;
        }
        ans=1;
        map<string, int>::iterator i;
        for(i=item.begin(); i!=item.end(); i++){
            ans*=(i->second)+1;
        }
        
        printf("%d\n", ans-1);
        item.clear();
    }
    
    
    return 0;
}

