import java.util.*;

public class Game {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    int z = (int) ((long) y * 100 / x);
    int result = -1;
    int left = 0;
    int right = 1000000000;
    
    while (left <= right) {
        int mid = (left + right) / 2;
        int currentZ = (int) ((long) (y + mid) * 100 / (x + mid));
        if (currentZ != z) {
            result = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    System.out.println(result);
  }
}