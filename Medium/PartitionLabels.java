package Medium;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Set<Character>> partSet = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (S.length() == 0)
            return res;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            Set<Character> tmp = new HashSet<>();
            tmp.add(c);
            partSet.add(tmp);
            res.add(1);

            for (int j = 0; j < partSet.size() - 1; j++) {
                Set<Character> set = partSet.get(j);
                if (set.contains(c)) {
                    merge(j, res, partSet);
                    break;
                }
            }
        }
        return res;
    }

    private void merge(int bound, List<Integer> res, List<Set<Character>> partSet) {
        Set<Character> mergeSet = partSet.get(bound);
        int mergeInt = res.get(bound);

        for (int i = res.size() - 1; i > bound; i--) {
            Set<Character> s = partSet.remove(i);
            mergeSet.addAll(s);
            int n = res.remove(i);
            mergeInt += n;
        }

        res.set(bound, mergeInt);
    }

    public static void main(String[] args) {
        PartitionLabels labels = new PartitionLabels();
        String str = "ababcbacadefegdehijhklij";
        System.out.println(labels.partitionLabels(str));
    }
}
