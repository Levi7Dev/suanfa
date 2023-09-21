package template;

public class Trie {
    public static int idx = 0;

    public static void main(String[] args) {
        int[][] son = new int[100010][26];
        //统计以某个节点为结束的字符串有多少个
        int[] cnt = new int[100010];
    }

    public static void insert(int[][] son, int[] cnt, char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    public static int query(int[][] son, int[] cnt, char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }
}
