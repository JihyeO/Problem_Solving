/*
 * 섬 연결하기 
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * 간선이 짧은 순서로 정렬, 하나씩 넣으면서 사이클이 생기지 않도록 부모 체크 후 다를 경우 경로로 선택 
 */

function solution(n, costs) {
    let answer = 0;
    const parent = [...new Array(n)].map((n, idx) => idx);
    const getParent = (idx) => {
        if (parent[idx] !== idx) {
            return getParent(parent[idx]);
        } else {
            return idx;
        }
    };
    
    costs.sort((a, b) => a[2] - b[2]);
    
    costs.forEach(cost => {
        const first = getParent(cost[0]);
        const second = getParent(cost[1]);
        if (parent[first] !== parent[second]) {
            answer += cost[2];
            if (parent[first] < parent[second]) parent[second] = parent[first];
            if (parent[second] < parent[first]) parent[first] = parent[second];
        } 
    });
    
    return answer;
}
