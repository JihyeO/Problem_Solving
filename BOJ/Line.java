import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/2631
 * 부분 수열을 구하는 점화식으로 접근한다.
 */

public class Line {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] numbers = new int[size];
        int[] dp = new int[size];
        int maxConsecutive = 1;
        
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i ++) {
            dp[i] = 1;
            for (int j = i - 1; j > -1; j--) {
                if (numbers[i] > numbers[j] && dp[j]+ 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            maxConsecutive = Math.max(maxConsecutive, dp[i]);
        }
        System.out.println(size - maxConsecutive);
    }
}