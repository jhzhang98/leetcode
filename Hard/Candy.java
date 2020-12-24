package Hard;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);
        if (ratings.length <= 1)
            return Arrays.stream(num).sum();
        if (ratings[0] > ratings[1])
            num[0] = num[1] + 1;
        for (int i = 1; i < num.length - 1; i++) {
            if (ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
            if (ratings[i] > ratings[i + 1])
                num[i] = Math.max(num[i + 1] + 1, num[i]);
        }
        if (ratings[ratings.length - 1] > ratings[ratings.length - 2])
            num[ratings.length - 1] = num[ratings.length - 2] + 1;
        for (int i = num.length - 2; i >= 1; i--) {
            if (ratings[i] > ratings[i - 1] && num[i] <= num[i - 1])
                num[i] = num[i - 1] + 1;
            if (ratings[i] > ratings[i + 1] && num[i] <= num[i + 1])
                num[i] = Math.max(num[i], num[i + 1] + 1);
        }
        if (ratings[0] > ratings[1] && num[0] <= num[1])
            num[0] = num[1] + 1;
        return Arrays.stream(num).sum();
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1,0,2,1,23,34,2,3,4,2,23,3,4,4,4,32,34,2,12,1,23,34,4,23,2,34,5,6,7,6,5,4,2,2,1,2,3,3,4,6,7,7,78,8,6,4,23,2,1,2,34,54,56,6};
        System.out.println(candy.candy(ratings));
    }
}
