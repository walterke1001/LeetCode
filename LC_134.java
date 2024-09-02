public class LC_134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int startIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                startIdx = i + 1;
                curSum = 0;
            }
        }
        return totalSum >= 0 ? startIdx : -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
