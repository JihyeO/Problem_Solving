import java.util.*;

/*
 * 문제: https://www.acmicpc.net/problem/20125
 * 이중 루프 내에서 한 번에 심장, 팔, 허리 길이를 잰다. 허리 길이는 다리에 도달 했을 때 잰다.
 * 다리는 새로운 이중 루프에서 세로로 잰다.
 * 난이도는 높지 않지만 인덱스를 여러 테스트 케이스를 포함하여 커버할 수 있도록 해야 한다.
 */

public class Cookie {
  public static void main(String args[]) {
    String[] input = {
        "9",
        "____*____",
        "*********",
        "____*____",
        "____*____",
        "____*____",
        "___*_*___",
        "___*_*___",
        "___*_*___",
        "___*_*___"
    };
    String[] input2 = {
        "10",
        "__________",
        "_____*____",
        "__******__",
        "_____*____",
        "_____*____",
        "_____*____",
        "____*_*___",
        "____*_____",
        "____*_____",
        "____*_____"
    };
    String[] input3 = {
        "5",
        "_____",
        "__*__",
        "_***_",
        "__*__",
        "_*_*_"
    };
    problem(input3);
  }
  public static void problem(String[] args) {
        int n = Integer.valueOf(args[0]);
        char[][] cookie = new char[n][n];
        for (int i = 1; i < n + 1; i++) {
            String line = args[i];
            for (int j = 0; j < n; j++) {
                cookie[i-1][j] = line.charAt(j);
            }
        }
                            
        int hx = 0, hy = 0, larm = 0, rarm = 0, lleg = 0, rleg = 0, waist = 0;
        int legX = 0, legY = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // find head
                if (hx == 0 && hy == 0 && cookie[x][y] == '*') {
                    hx = x + 1;
                    hy = y;
                    x++;
                    y = 0;
                }
                // arm
                if (hx != 0 && larm == 0 && cookie[x][y] == '*') {
                    larm = hy - y;
                    y = hy + 1;
                }
                if (hx != 0 && larm != 0 && rarm == 0) {
                    if (cookie[x][y] == '_') {
                        rarm = (y - 1) - hy;
                    } else if (y == n - 1) {
                        rarm = y - hy;
                    }
                    continue;
                }
                // waist
                if (hx != 0 && larm != 0 && rarm != 0 && cookie[x][y] == '*' && cookie[x-1][y] == '_'
                    && cookie[x-1][y+1] == '*' && cookie[x-1][y+2] == '_'){
                    legX = x;
                    legY = y;
                    waist = (x - 1) - hx;
                    break;
                }
            }
            if (legX != 0) break;
        }
        // leg
        for (int x = legX; x < n; x++) {
            if (cookie[x][legY] == '_') break;
            lleg++;
        }
        for (int x = legX; x < n; x++) {
            if (cookie[x][legY + 2] == '_') break;
            rleg++; 
        }
        
        System.out.println((hx + 1) + " " + (hy + 1));
        System.out.println(larm + " " + rarm + " " + waist + " " + lleg + " " + rleg);
    }
}
