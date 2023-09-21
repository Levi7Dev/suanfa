package xiecheng;



import java.util.*;

public class Main2 {
    static List<Map<Character, Integer>> lie = new ArrayList<>();
    static List<Map<Character, Integer>> hang = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char[][] matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('y', 0);
            map.put('o', 0);
            map.put('u', 0);
            hang.add(map);
        }
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('y', 0);
            map.put('o', 0);
            map.put('u', 0);
            lie.add(map);
        }

        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                matrix[i][j] = c;
                if (c == 'y' || c == 'u' || c == 'o') {
                    int cnt = hang.get(i).get(c);
                    hang.get(i).put(c, cnt + 1);
                    cnt = lie.get(j).get(c);
                    lie.get(j).put(c, cnt + 1);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = matrix[i][j];
                if (c == 'y') {
                    ans += lie.get(j).get('o') * hang.get(i).get('u')
                            + lie.get(j).get('u') * hang.get(i).get('o');
                } else if (c == 'o') {
                    ans += lie.get(j).get('y') * hang.get(i).get('u')
                            + lie.get(j).get('u') * hang.get(i).get('y');
                } else if (c == 'u') {
                    ans += lie.get(j).get('y') * hang.get(i).get('o')
                            + lie.get(j).get('o') * hang.get(i).get('y');
                }
            }
        }
        System.out.println(ans);
    }
}













