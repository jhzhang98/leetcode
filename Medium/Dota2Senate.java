package Medium;

import java.util.ArrayList;
import java.util.List;

public class Dota2Senate {
    private boolean banOne(List<Integer> list, int voteIndex) {
        int banPerson = 1 - list.get(voteIndex);
        boolean firstRoute = true;
        for (int i = voteIndex; i < list.size(); i++) {
            if (!firstRoute && i == voteIndex)
                return false;
            if (list.get(i) == banPerson) {
                list.remove(i);
                return true;
            }
            if (i == list.size() - 1 && firstRoute){
                i = -1;
                firstRoute = false;
            }
        }
        return false;
    }

    public String predictPartyVictory(String senate) {
        List<Integer> list = new ArrayList<>();
        for (char c : senate.toCharArray())
            list.add(c == 'R' ? 1 : 0);
        int index = 0;
        while (banOne(list, index)) {
            index++;
            if (index >= list.size())
                index = 0;
        }
        if (list.get(0) == 1)
            return "Radiant";
        else
            return "Dire";
    }

    public static void main(String[] args) {
        Dota2Senate dota2Senate = new Dota2Senate();
        String senate = "RDRDD";
        System.out.println(dota2Senate.predictPartyVictory(senate));
    }
}
