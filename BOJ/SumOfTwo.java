import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/3273
 * 투 포인터 방식으로 해결
 */

public class SumOfTwo {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
          nums[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      
      Arrays.sort(nums);
      int left = 0, right = n - 1;
      int answer = 0;
  
      while (left < right) {
          int sum = nums[left] + nums[right];
          if (sum == target) {
              answer++;
              left++;
              right--;
          } else if (sum < target) {
              left++;
          } else {
              right--;
          }
      }
      System.out.println(answer);
    }
}