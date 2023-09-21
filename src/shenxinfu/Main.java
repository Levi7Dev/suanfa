package shenxinfu;


import java.util.*;


public class Main {
//            "daniel","daniel","daniel","luis","luis","luis","luis"
//            "10:00","10:40","11:00","09:00","11:00","13:00","15:00"
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        String[] names = in.next().split(",");
        String[] times = in.next().split(",");
        for (int i = 0; i < times.length; i++) {
            String[] splitTime = times[i].split(":");
//            System.out.println("shi:" + splitTime[0].substring(1));
//            System.out.println("fen:"+ splitTime[1].substring(0, splitTime[1].length() - 1));
            int time = Integer.parseInt(splitTime[0].substring(1)) * 60
                    + Integer.parseInt(splitTime[1].substring(0, splitTime[1].length() - 1));
//            System.out.println("time:" + time);
            if (map.containsKey(names[i])) {
                TreeSet<Integer> set = map.get(names[i]);
                set.add(time);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(time);
                map.put(names[i], set);
            }
        }
        //System.out.println(map.toString());
        //遍历map和set
        List<String> list = new ArrayList<>();
        Iterator<Map.Entry<String, TreeSet<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, TreeSet<Integer>> next1 = iterator.next();
            System.out.println(next1.toString());
            TreeSet<Integer> value = next1.getValue();
            for (int i = 0; i < 1440; i++) {
                int cnt = 0;
                //别定义在for循环外层，每一轮循环需要重新计算
                Iterator<Integer> it = value.iterator();
                while (it.hasNext()) {
                    int next = it.next();
                    if (next >= i && next <= i + 60) {
                        System.out.println(cnt);
                        cnt++;
                    }
                }
                if (cnt >= 3) {
                    list.add(next1.getKey());
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}


//    public static void getAns2() {
//        Scanner in = new Scanner(System.in);
//        String times = in.next();
//        String score = in.next();
//        int t = in.nextInt();
//        String[] split = times.split(",");
//        String[] split1 = score.split(",");
//        int[] weight = new int[split.length];
//        int[] value = new int[split1.length];
//        for (int i = 0; i < split.length; i++) {
//            value[i] = Integer.parseInt(split1[i]);
//            weight[i] = Integer.parseInt(split[i]);
//        }
//        int[] dp = new int[t + 1];
//        for (int i = 0; i < value.length; i++) {
//            for (int j = t; j >= weight[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//            }
//        }
//        System.out.println(dp[t]);
//    }


//    public static String getStr(String st) {
//        String regex = "(.)\\1{2,}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(st);
//        while (matcher.find()) {
//            st = st.replaceAll(regex, "");
//            matcher = pattern.matcher(st);
//        }
//        return st;
//    }

