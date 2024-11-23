import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/11722
 * DP 점화식을 구한다.
 */
public class Subsequence {
  public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] numbers = new int[n];
      int[] dp = new int[n];
      int max = 1;
      
      for (int i = 0; i < n; i++) {
          numbers[i] = sc.nextInt();
          dp[i] = 1;
      }
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (numbers[j] > numbers[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
          }
          max = Math.max(max, dp[i]);
      }
      
      System.out.println(max);
  }
}
