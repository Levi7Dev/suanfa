import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String moneyStr = in.nextLine();
        String goodsStr = in.nextLine();

        Map<String, List<Map<String, Integer>>> result = new HashMap<>();
        List<Map<String, Integer>> list = new ArrayList<>();
        Map<String, Integer> money = new HashMap<>();
        Map<String, Integer> goods = new HashMap<>();

        getData(moneyStr, money);
        getData(goodsStr, goods);

        //先遍历金钱，再遍历订单
        for (Map.Entry<String, Integer> entry1 : money.entrySet()) {
            for (Map.Entry<String, Integer> entry2 : goods.entrySet()) {

            }
        }


        //输入输出是啥?
//        Map<String, List<Map<String, Integer>>> map1 = new HashMap<>();
//        Map<String, Integer> map2 = new HashMap<>();
//        List<Map<String, Integer>> list = new ArrayList<>();
//        map2.put("A", 34);
//        map2.put("B", 24);
//        list.add(map2);
//        map1.put("A", list);
//        //{A=[{A=34, B=24}]}
//        //{A=34, B=24}
//        System.out.println(map1.toString());
//        System.out.println(map2.toString());
    }

    public static void getData(String data, Map<String, Integer> map) {
        String[] strings = data.split(",");
        for (String str : strings) {
            String[] split = str.split(":");
            map.put(split[0], Integer.parseInt(split[1]));
        }
    }
}
