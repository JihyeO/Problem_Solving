import java.util.*;

/**
 *
 * Programmers 네트워크
 * DFS
 *
 * Stack을 사용해 연결되어 있는 컴퓨터를 모두 돌며 네트워크 개수를 계산한다.
 */

class Network {
    public int[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for (int i = 0 ; i < n; i++) {
            if (visited[i] != 1) {
                dfs(i, n, computers);
                answer++;
            } 
        }
        
        return answer;
    }
    
    public void dfs(int start, int n, int[][] computers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        
        while(!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = 1;
            for (int i = 0; i < n; i++) {
                if (current != i && computers[current][i] == 1 && visited[i] != 1) {
                    stack.push(i);
                }
            }
        }
    }
}