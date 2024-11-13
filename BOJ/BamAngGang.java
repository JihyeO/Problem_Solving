import java.util.*;

/*
 * 문졔: https://www.acmicpc.net/problem/31926
 * n이 짝수인지 홀수인지에 따라 마지막으로 끝나는 단어 'daldidan'을 2번 복사하냐 1번만 복사하냐가 달라진다.
 * 홀수: 'daldidalgo daidida', 'n' 복사, 짝수: 'daldidalgo', 'daldida', 'n' 복사
 */

public class BamAngGang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 8;
        int n = sc.nextInt();
        
        for (int i = 1; ; i++) {
			if (n - Math.pow(2, i) == 0) {
				result = result + i + 2;
				break;
			} else if (n - Math.pow(2, i) < 0) {
				result = result + i + 1;
				break;
			}
		}
        System.out.println(result);
    }
}