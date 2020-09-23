  
/**
 *
 * Programmers 가장 먼 노드 
 * BFS
 *
 * 배열에 각 노드 연결 관계를 저장, 1에 연결된 노드를 담은 상태로 BFS
 * 방문 하지 않은 노드의 경우 visited에 각 depth를 저장해나감 
 * 처음엔 int형 배열로 풀었지만 메모리 초과로 인해 boolean으로 수정, 이 부분도 발전이 필요해보임
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
