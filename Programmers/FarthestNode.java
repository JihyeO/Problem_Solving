  
/**
 *
 * Programmers 가장 먼 노드 
 * BFS
 *
 * 배열에 담았던 node 간 연결 관계를 ArrayList에 담아 필요한 값만 저장해나감, 1에 연결된 노드를 담은 상태로 BFS
 * 방문 하지 않은 노드의 경우 visited에 각 depth를 저장해나감
 */
 
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] node = new ArrayList[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n+1];
        int max = 0, answer = 0;
        
        visited[1]=1;
        
        for(int i=0; i<edge.length; i++){
            int first = edge[i][0];
            int second = edge[i][1];
            if(node[first] == null) node[first] = new ArrayList<Integer>();
            node[first].add(second);
            if(node[second] == null) node[second] = new ArrayList<Integer>();
            node[second].add(first);
            if(first == 1){
                queue.offer(second);
                visited[second] = 1;
            }else if(second == 1){
                queue.offer(first);
                visited[first] = 1;
            }
        }
        
        while(!queue.isEmpty()){
            int start = queue.poll();
            max = visited[start];
            while(!node[start].isEmpty()){
                int current = node[start].get(0);
                node[start].remove(0);
                if(visited[current]==0){
                    queue.offer(current);
                    visited[current] = visited[start] + 1;
                }
            }  
        }
        
        for(int k=1; k<=n; k++){
            if(visited[k] == max) answer ++;
        }
        
        return answer;
    }
}
