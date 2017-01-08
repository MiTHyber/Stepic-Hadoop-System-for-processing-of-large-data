import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int numV = sc.nextInt();
            int numE = sc.nextInt();
            int[][] w = new int[numV][numV];
            for (int i = 0; i < numE; i++) {
                int fV = sc.nextInt();
                int tV = sc.nextInt();
                w[fV - 1][tV - 1] = sc.nextInt();
            }
            int startV = sc.nextInt() - 1;
            int endV = sc.nextInt() - 1;
            Set<Integer> vertexes = new HashSet<>();
            for (int i = 0; i < numV; i++) {
                vertexes.add(i);
            }
            int[] d = new int[numV];
            for (int i = 0; i < numV; i++)
                d[i] = Integer.MAX_VALUE / 2;
            d[startV] = 0;
            while (vertexes.size() != 0) {
                Integer min = extractMin(vertexes, d);
                for (int i = 0; i < numV; i++) {
                    if (w[min][i] != 0 && d[i] > d[min] + w[min][i])
                        d[i] = d[min] + w[min][i];
                }
            }
            if (d[endV] != Integer.MAX_VALUE / 2)
                System.out.println(d[endV]);
            else
                System.out.println(-1);
        }
    }

    static int extractMin(Set<Integer> vertexes, int[] d) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (Integer i : vertexes) {
            if (d[i] < min) {
                min = d[i];
                minIndex = i;
            }
        }
        vertexes.remove(minIndex);
        return minIndex;
    }
}
