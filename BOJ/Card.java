import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/13417
 * 현재 뽑은 알파벳을 앞에 둘지 뒤에 둘지 문자열의 첫 글자와 비교하여 붙임
 */

public class Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String result = sc.next();
            for (int j = 1; j < n; j++) {
                char alphabet = sc.next().charAt(0);
                result = result.charAt(0) >= alphabet ? alphabet + result : result + alphabet;
            }
            System.out.println(result);
        }
    }
}