/*
 * K번째 수
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * 지정된 범위까지 자른 후 정렬(숫자 고려), 특정 위치의 수 반환 
 */

function solution(array, commands) {
    return commands.reduce((result, command) => {
        const cutAndSorted = array.slice(command[0] - 1, command[1]).sort((a, b) => a - b);
        result.push(cutAndSorted[command[2] - 1]);
        return result;
    }, []);
}
