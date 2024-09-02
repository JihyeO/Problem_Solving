import java.util.*;

/*
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * 플로이드 와샬 (Floyd Warshall) 알고리즘으로 해결
 */
class Rank {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n][n];
        
        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]-1][results[i][1]-1] = 1;
            graph[results[i][1]-1][results[i][0]-1] = -1;
        }
        for (int j = 0; j < n; j++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (graph[x][j] == 1 && graph[j][y] == 1) {
                        graph[x][y] = 1;
                        graph[y][x] = -1;
                    }
                    if (graph[x][j] == -1 && graph[j][y] == -1) {
                        graph[x][y] = -1;
                        graph[y][x] = 1;
                    } 
                }
            }   
        }
        
        for (int k = 0; k < n; k++) {
            int winOrLoseCnt = 0;
            for (int l = 0; l < n; l++) {
                if (graph[k][l] != 0) winOrLoseCnt++;
            }
            if (winOrLoseCnt == n - 1) answer++;
        }
        
        return answer;
    }
}