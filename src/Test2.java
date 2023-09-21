import java.util.*;

public class Test2 {
    static boolean[] used; // 最后哪些能染色
    static MyNode[] nodes; // 我的所有节点
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 服务节点总数
        int n = sc.nextInt(); // 服务调用响应耗时或者服务自身计算耗时 reTimes 的长度
        nodes = new MyNode[m + 1];
        used = new boolean[m + 1];
        while (n-- > 0) {
            int srcService = sc.nextInt();
            int dstService = sc.nextInt();
            int rsTime = sc.nextInt();
            if (nodes[srcService] == null) {
                nodes[srcService] = new MyNode();
                nodes[srcService].dstServices = new ArrayList<>();
                nodes[srcService].rsTimes = new ArrayList<>();
                nodes[srcService].self = rsTime;
            } else {
                nodes[srcService].dstServices.add(dstService);
                nodes[srcService].rsTimes.add(rsTime);
            }
        }
        int srcService = sc.nextInt(); // 调用方源路径
        int max = dfs(nodes[srcService], srcService);
        int count = 0;
        for (boolean isok : used) if (isok) count++;
        System.out.println(count);
        System.out.println(max - nodes[srcService].self);

    }
    static int dfs(MyNode node, int n) {
        used[n] = true;
        if (node.dstServices.size() == 0) {
            return node.self;
        }
        int max = 0;
        for (int i = 0; i < node.dstServices.size(); i++) {
            max = Math.max(max, dfs(nodes[node.dstServices.get(i)], node.dstServices.get(i)) + node.rsTimes.get(i));
        }
        return max + node.self;
    }


}

class MyNode {
    List<Integer> dstServices;
    List<Integer> rsTimes;
    int self;
}
