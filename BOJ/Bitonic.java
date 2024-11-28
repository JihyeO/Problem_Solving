import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/11054
 * DP를 활용, LIS와 LDS를 조합한다.
 */
public class Bitonic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] lis = new int[n];
        int[] lds = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            lis[i] = 1;
            lds[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (numbers[i] > numbers[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        
        int result = 0;
        for (int k = 0; k < n; k++) {
            result = Math.max(result, lis[k] + lds[k]);
        }
        System.out.println(result - 1);
    }
}