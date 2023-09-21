package template;

public class Graph {
    public static final int N = 100010;
    public static int idx = 0;
    //头，需初始化为-1
    public static int[] h = new int[N];
    public static int[] e = new int[N * 2]; //无向图开两倍大小
    public static int[] ne = new int[N * 2];

    public static void main(String[] args) {

    }

    //在a->b之间建立边
    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    //以某个点为起点，遍历图
    public static void bfs(int u) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            //...
        }
    }

}
