import java.util.*;

public class City {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        int[] distance = new int[n+1];
        
        Arrays.fill(distance, -1);
        distance[x] = 0;
        queue.add(x);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int linkedCity : list.get(current)) {
                if (distance[linkedCity] == -1) {
                    queue.add(linkedCity);
                    distance[linkedCity] = distance[current] + 1;
                }
            }
        }
        
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) System.out.println(-1);
    }
}