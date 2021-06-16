package Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaximumFrequencyStack {

}

class FreqStack {
    private final Map<Integer, Integer> valFreq;
    private final Map<Integer, Stack<Integer>> freqMap;
    private int maxFreq;

    public FreqStack() {
        valFreq = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void push(int val) {
        int freq = valFreq.getOrDefault(val, 0) + 1;
        valFreq.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        if (freqMap.containsKey(freq))
            freqMap.get(freq).push(val);
        else {
            Stack<Integer> stack = new Stack<>();
            stack.add(val);
            freqMap.put(freq, stack);
        }
    }

    public int pop() {
        int res = freqMap.get(maxFreq).pop();
        if (freqMap.get(maxFreq).size() == 0)
            maxFreq--;
        valFreq.put(res, valFreq.get(res) - 1);
        return res;
    }
}