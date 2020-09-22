package Easy;

import java.util.*;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> startCity = new HashSet<>();
        for (List<String> path : paths){
            startCity.add(path.get(0));
        }
        for (List<String> path: paths){
            if (!startCity.contains(path.get(1))){
                return path.get(1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DestinationCity dest = new DestinationCity();
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("B", "C"));
        paths.add(Arrays.asList("D", "B"));
        paths.add(Arrays.asList("C", "A"));
        System.out.println(dest.destCity(paths));

    }
}
