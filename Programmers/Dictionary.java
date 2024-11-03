import java.util.*;

/*
 * 모음 사전
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * DFS로 해결
 * 
 */

class Solution {
    private Map<String, Integer> dictionary = new HashMap<>();
    private int order = 0;
    
    public int solution(String word) {
        makeDictionary("");
        return dictionary.get(word);
    }
    
    public void makeDictionary(String word) {
        dictionary.put(word, order);
        order++;
        
        for (int i = 0; i < 5; i++) {
            if (word.length() < 5) {
                makeDictionary(word + "AEIOU".charAt(i));
            } else {
                break;
            }
        }
    }
}