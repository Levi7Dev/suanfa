package template;

//并查集
public class UnionFind {
    static int[] p = new int[100010];

    public static void main(String[] args) {
        //刚开始元素各自在一个集合中，表明父节点是自己
        for (int i = 0; i < 100010; i++) {
            p[i] = i;
        }
        int a = 1;
        int b = 2;
        //将a，b两个元素合并在同一个集合中
        p[find(a)] = find(b);

        int c = 3, d = 3;
        //是否在同一集合中
        if (find(c) == find(d)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    //返回该节点的父节点
    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

}
