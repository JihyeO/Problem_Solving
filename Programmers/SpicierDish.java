import java.util.*;

/*
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * 최소 힙을 사용하여 해결
 */
class SpicierDish {
    public int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        int min = pq.peek();
        while(min < K) {
            if (pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                pq.add(first + second * 2);
                result++;
                min = pq.peek();
            } else {
                return -1;
            }
        }
        return result;
    }
}