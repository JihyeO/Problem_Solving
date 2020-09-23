  
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
    public int solution(int n, int[][] edge) {
        boolean[][] node = new boolean[n+1][n+1];
        int[] visited = new int[n+1];
        Queue<Integer> queue = new LinkedList<>(); 
        int max = 0;
        int answer = 0;

        visited[1]=1;

        for(int i=0; i<edge.length; i++){
            int first = edge[i][0];
            int second = edge[i][1];
            node[first][second] = true;
            node[second][first] = true;
            if(first==1){
                queue.offer(second);
                visited[second] = 1;
            }else if(second==1){
                queue.offer(first);
                visited[first] = 1;
            }
        }

        while(!queue.isEmpty()){
            int start = queue.poll();
            max = visited[start];
            for(int j=1; j<=n; j++){
                if(node[start][j] && visited[j]==0){
                    queue.offer(j);
                    visited[j] = visited[start] + 1;
                }
            }    
        }

        for(int k=0; k<n+1; k++){
            if(visited[k] == max) answer ++;
        }

        return answer;
    }
}
