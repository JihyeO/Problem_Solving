import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/2847
 * 스택으로 담고, 가장 높은 레벨 점수를 시작으로 낮은 레벨로 꺼내면서 점수를 조정한다.
 */
public class Level {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        
        int result = 0;
        int prevScore = stack.pop();
        while (!stack.isEmpty()) {
            int currentScore = stack.pop();
            if (prevScore <= currentScore) {
                prevScore--;
                result += currentScore - prevScore;
            } else {
                prevScore = currentScore;
            }
        }
        System.out.println(result);
    }
}