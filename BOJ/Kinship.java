import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/2644
 * DFS를 활용해 촌수를 계산.
 */

public class Kinship {
    private static int map[][];
    private static int visited[];
    private static int n;
    private static int result = -1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int m = sc.nextInt();
        
        map = new int[n+1][n+1];
        visited = new int[n+1];
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            map[parent][child] = 1;
            map[child][parent] = 1;
        }
    
        dfs(p1, p2, 0);
        System.out.println(result);
    }
    
    public static void dfs (int p1, int p2, int cnt) {
        if (p1 == p2) {
            result = cnt;
            return;
        }
    
        visited[p1] = 1;
        for (int i = 1; i <= n; i++) {
          if (map[p1][i] != 0 && visited[i] == 0) {
              dfs(i, p2, cnt + 1);
          }
        }
    }
}