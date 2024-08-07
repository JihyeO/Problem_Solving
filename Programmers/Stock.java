/*
 * 주식 가격
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * 이중 for문으로 구현했지만, 스택으로 다시 풀어보자!
 */

 class Solution {
  public int[] solution(int[] prices) {
      int[] answer = new int[prices.length];
      for (int i = 0; i < prices.length; i++) {
          for (int j = i + 1; j < prices.length; j++) {
              answer[i]++;
              if (prices[i] > prices[j]) break;
          }
      }
      return answer;
  }
}