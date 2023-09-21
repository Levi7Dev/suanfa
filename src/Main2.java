import java.util.*;

public class Main2 {

    public static void printManyou(List<List<Integer>> manyou) {
        for (List<Integer> node : manyou) {
            System.out.println( "====:" + node.get(0) + " " + node.get(1) + " " + node.get(2));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //风险地区的数量(每一行代表一个风险地区，每一列代表日期，1为风险)
        int[][] risk = new int[1010][1010];
        List<List<Integer>> manyou = new ArrayList<>();

        //n天数据
        int r, m; //风险地区数量，漫游数据数量
        for (int i = 0; i < n; i++) {
            //存放用户，排好序
            Set<Integer> result = new TreeSet<>();

            r = in.nextInt();
            m = in.nextInt();
            //输入r条风险地区
            int p;  //风险地区编号
            while (r-- > 0) {
                p = in.nextInt();
                //从当日起(i日起)，7天内该地区为风险状态
                for (int j = i; j < i + 7; j++) {
                    risk[p][j] = 1;
                }
            }
            //输入m条漫游数据，漫游数据存在重复
            while (m-- > 0) {
                int d = in.nextInt();
                int u = in.nextInt();
                int rr = in.nextInt();
                if (d < 0) {
                    continue;
                }
                //到访日该地区不是风险地区，则用户肯定没有风险
                if (risk[rr][d] != 1) {
                    continue;
                }
                manyou.add(Arrays.asList(d,u,rr));
            }
            printManyou(manyou);
            //处理漫游数据，存在收到之前的数据
            for (int ii = Math.max(0, i - 6); ii <= i; ii++) {
                //遍历每一条漫游数据
                for (int jj = 0; jj < manyou.size(); jj++) {
                    List<Integer> temp = manyou.get(jj);
                    //System.out.println("temp.d: " + temp.d);
                    //只处理7日内的数据
                    if (temp.get(0) <= i - 7) {
                        continue;
                    }
                    int day, user, area;
                    day = temp.get(0);
                    user = temp.get(1);
                    area = temp.get(2);

                    boolean flag = true;
                    //判断到今日是否连续处于风险状态
                    for (int k = day; k <= i; k++) {
                        //System.out.println("risk[area][k]: " + risk[area][k]);
                        if (risk[area][k] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result.add(user);
                    }
                }
            }
            //输出
            System.out.print(i + " ");
            for (Integer item : result) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
