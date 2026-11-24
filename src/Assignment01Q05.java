public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i==j) {
            return 0;
        }
        int n = m.length;
        int[] dist = new int[n];
        for (int k=0; k<n; k++) {
            dist[k] = -1;
        }

        int [] queue = new int[n];
        int head = 0;
        int tail = 0;
        dist[i] = 0;
        queue[tail] = i;
        tail++;

        while (head < tail) {
            int cur = queue[head];
            head++;
            for (int k=0; k<n; k++) {
                if (m[cur][k] == 1 && dist[k] == -1) {
                    dist[k] = dist[cur] + 1;
                    if (k == j) {
                        return dist[k]; 
                    }
                    queue[tail] = k;
                    tail++;
                }
            }    
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}