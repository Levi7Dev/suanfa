import java.util.*;

public class Test{
    //2 3 4 1 5 x 7 6 8
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String start = "";
        for (int i = 0; i < 9; i++) {
            start += in.next();
        }

        int ans = BFS(start);
        System.out.println(ans);
    }

    public static int BFS(String start) {
        //终止状态
        String end = "12345678x";
        //存放每个字符串它交换了多少次
        Map<String, Integer> map_count = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        map_count.put(start, 0);

        while (!queue.isEmpty()) {
            StringBuilder first = new StringBuilder(queue.poll());
            System.out.println(first.toString());
            int distance = map_count.getOrDefault(first.toString(), 0);
            //找到了最终的状态，直接返回
            if (first.toString().equals(end)) {
                return distance;
            }

            //右左上下四个方向
            int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
            int k = first.indexOf("x");
            //x在矩阵中的坐标
            int x = k / 3, y = k % 3;
            for (int i = 0; i < 4; i++) {
                //a,b为在矩阵中的坐标，转换为一维数组的下标为 a * 3 + b
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    //交换x的位置
                    char t = first.charAt(k);
                    first.setCharAt(k, first.charAt(a * 3 + b));
                    first.setCharAt(a * 3 + b, t);
                    //该状态是第一次走到
                    if (map_count.getOrDefault(first.toString(), -1) == -1) {
                        map_count.put(first.toString(), distance + 1);
                        queue.offer(first.toString());
                    }
                    //恢复状态
                    t = first.charAt(k);
                    first.setCharAt(k, first.charAt(a * 3 + b));
                    first.setCharAt(a * 3 + b, t);
                }
            }
        }

        return -1;
    }
}