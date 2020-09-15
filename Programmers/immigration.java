/**
 *
 * Programmers 입국심사 
 * 이분 탐색
 *
 * 1분을 left, 입국심사 최대 시간을 right으로 두고 중간 값을 구한다. 
 * 중간 값동안 각 심사관이 최대 몇명을 심사할 수 있는지 계산 후, 총 인원수와 비교해가며 left와 right 값을 조절해나간다. 
 */

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 1, r = (long) n * times[times.length-1], m = 0;
        long answer = 0;
        
        while(l <= r){
            m = (l + r) / 2;
            long totalPeople = 0;
            for(int i = 0; i < times.length; i++){
                totalPeople += m/times[i];
            }
            if(totalPeople >= n){
                answer = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return answer;
    }
}
