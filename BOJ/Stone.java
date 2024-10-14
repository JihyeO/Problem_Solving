import java.util.Scanner;

/*
 * 문제: https://www.acmicpc.net/problem/9655
 * N을 1부터 하나씩 증가시켜가며 규칙을 발견해보니 N-1 승리자의 반대가 N 승리자.
 * 상근이 먼저 시작하는 게임으로 홀수는 상근이 이기고 짝수는 창영이 이긴다.
 * 코드는 단순하지만 try-with-resources로 Scanner 객체를 자동으로 닫아준다.
 */

public class Stone {
  public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(sc.nextInt() % 2 == 0 ? "CY" : "SK");
        }
    }
}
