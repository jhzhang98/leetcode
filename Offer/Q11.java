package Offer;

public class Q11 {
    public int minArray(int[] numbers) {
        int res = numbers[0];
        for (int i=1 ; i<numbers.length ; i++){
            if (numbers[i] < numbers[i-1]){
                res = numbers[i];
                break;
            }
        }
        return res;
    }
}
