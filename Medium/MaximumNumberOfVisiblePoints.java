package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int posX = location.get(0);
        int posY = location.get(1);
        double anglePI = angle * 1.0 / 180 * Math.PI;
        int visiblePoints = 0;
        List<Double> degree = new ArrayList<>();
        for (List<Integer> point : points) {
            int pX = point.get(0);
            int pY = point.get(1);
            double deltaX = pX - posX;
            double deltaY = pY - posY;
            if (-1e-6 < deltaX && deltaX < 1e-6 && -1e-6 < deltaY && deltaY < 1e-6) {
                visiblePoints++;
            } else if (deltaX > 0 && deltaY >= 0) {
                degree.add(Math.atan(deltaY / deltaX));
                degree.add(Math.atan(deltaY / deltaX) + 2 * Math.PI);
            } else if (deltaX > 0 && deltaY < 0) {
                degree.add(Math.atan(deltaY / deltaX) + 2 * Math.PI);
            } else if (deltaX < 0 && deltaY <= 0) {
                degree.add(Math.atan(deltaY / deltaX) + Math.PI);
            } else if (deltaX < 0 && deltaY > 0) {
                degree.add(Math.atan(deltaY / deltaX) + Math.PI);
                degree.add(Math.atan(deltaY / deltaX) + 3 * Math.PI);
            } else{
                System.out.println("leak !!!!!");
            }
        }
        Collections.sort(degree);
        int localVisible = 0;
        for (int i = 0; i < degree.size(); i++) {
            int visiblePointsWindow = 0;
            for (int j = i; j < degree.size(); j++) {
                if (degree.get(j) - degree.get(i) > anglePI)
                    break;
                visiblePointsWindow++;
            }
            localVisible = Math.max(localVisible, visiblePointsWindow);
        }

        return visiblePoints + localVisible;
    }

    public static void main(String[] args) {
        MaximumNumberOfVisiblePoints visiblePoints = new MaximumNumberOfVisiblePoints();
        int angle = 90;
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(0, 0));
        points.add(Arrays.asList(0, 2));
        List<Integer> pos = new ArrayList<>(Arrays.asList(1, 1));
        System.out.println(visiblePoints.visiblePoints(points, angle, pos));
    }
}