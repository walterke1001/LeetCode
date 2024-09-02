import java.util.HashMap;

public class LC_860 {
    public static boolean lemonadeChange(int[] bills) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("five", 0);
        map.put("ten", 0);
        map.put("twenty", 0);
        for (int i = 0; i < bills.length; i++) {
            if (i == 0 && bills[i] > 5) return false;
            if (bills[i] == 5) {
                map.put("five", map.getOrDefault("five", 0) + 1);
            } else if (bills[i] == 10) {
                int fiveNums = map.get("five");
                if (fiveNums < 1) return false;
                else {
                    map.put("ten", map.getOrDefault("ten", 0) + 1);
                    fiveNums--;
                    map.put("five", fiveNums);
                }
            } else {
                int fiveNums = map.get("five");
                int tenNums = map.get("ten");
                if (fiveNums < 1) {
                    return false;
                } else {
                    if (tenNums >= 1) {
                        map.put("five", fiveNums - 1);
                        map.put("ten", tenNums - 1);
                    } else if (fiveNums >= 3) {
                        map.put("five", fiveNums - 3);
                    } else return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills));
    }
}
