import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/11561
 * 등차수열의 합과 이분탐색을 활용한다.
 */

public class Bridge {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt(); 
    
    for (int i = 0; i < testCase; i++) {
        long n = sc.nextLong();
        long left = 0;
        long right = (long) Math.pow(10, 10);
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sequenceSum = mid * (mid + 1) / 2;
            if (sequenceSum <= n) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);  
    }
  }
}