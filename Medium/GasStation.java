package Medium;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long netGas = Arrays.stream(gas).sum() - Arrays.stream(cost).sum();
        if (netGas < 0)
            return -1;
        int[] net = new int[gas.length];
        for (int i = 0; i < gas.length; i++)
            net[i] = gas[i] - cost[i];

        for (int i = 0; i < gas.length; i++) {
            if (net[i] >= 0) {
                long localNetGas = 0;
                boolean continueFlag = false;
                for (int j = i; j < gas.length; j++) {
                    localNetGas += net[j];
                    if (localNetGas < 0) {
                        i = j;
                        continueFlag = true;
                        break;
                    }
                }
                if (continueFlag) continue;
                for (int j = 0; j < i; j++) {
                    localNetGas += net[j];
                    if (localNetGas < 0) {
                        return -1;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation station = new GasStation();
        int[] gas = {6, 1, 4, 3, 5};
        int[] cost = {3, 8, 2, 4, 2};
        System.out.println(station.canCompleteCircuit(gas, cost));
    }
}
