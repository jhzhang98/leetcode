package Hard;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        int energy = 0;
        for (int[] task : tasks) energy += task[0];
        int totalEnergy = energy;
        Arrays.sort(tasks, ((o1, o2) -> Integer.compare(o2[1] - o2[0], o1[1] - o1[0])));

        for (int[] task : tasks) {
            if (energy >= task[1])
                energy -= task[0];
            else {
                totalEnergy += task[1] - energy;
                energy = task[1] - task[0];
            }
        }
        return totalEnergy;
    }
}
