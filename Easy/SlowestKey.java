package Easy;

import java.util.Arrays;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] charTime = new int[26];
        char[] key = keysPressed.toCharArray();
        charTime[key[0] - 'a'] = releaseTimes[0];

        int max = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            charTime[key[i] - 'a'] = Math.max(charTime[key[i] - 'a'], releaseTimes[i] - releaseTimes[i-1] );
            max = Math.max(max, charTime[key[i] - 'a']);
        }

        for (int i=charTime.length - 1 ; i>=0 ; i--){
            if (max == charTime[i])
                return (char) ('a' + i);
        }
        return '1';
    }

    public static void main(String[] args) {
        SlowestKey key = new SlowestKey();
        int[] releaseTimes = {12,23,36,46,62};
        String keysPressed = "spuda";
        System.out.println(key.slowestKey(releaseTimes, keysPressed));
    }
}
