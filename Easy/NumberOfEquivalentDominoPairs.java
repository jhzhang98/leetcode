package Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {
    class Inner {
        int[] domino;

        public Inner(int[] domino) {
            this.domino = domino;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inner inner = (Inner) o;
            return Arrays.equals(domino, inner.domino);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(domino);
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] domino : dominoes) {
            if (domino[0] > domino[1]) {
                int tmp = domino[0];
                domino[0] = domino[1];
                domino[1] = tmp;
            }
        }
        Map<Inner, Integer> count = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Inner domino = new Inner(dominoes[i]);
            if (!count.containsKey(domino))
                count.put(domino, 0);
            else
                count.put(domino, count.get(domino) + 1);
        }
        int res = 0;
        for (Inner domino : count.keySet()) {
            int num = count.get(domino);
            if (num != 0) {
                res += (1 + num) * num / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {2, 1}, {2, 1}, {2, 1}, {3, 4}, {5, 6}, {3, 4},{3, 4}};
        System.out.println(new NumberOfEquivalentDominoPairs().numEquivDominoPairs(dominoes));
    }
}
