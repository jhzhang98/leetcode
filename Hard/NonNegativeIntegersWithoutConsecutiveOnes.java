package Hard;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    int[] tag = new int[31];

    private boolean match(int num) {
        int upper = (int) (Math.log(num) / Math.log(2)) + 1;
        for (int i = 0; i < upper; i++) {
            if ((num & tag[i]) == tag[i])
                return false;
        }
        return true;
    }

    /**
     * 正确，但是会超时，反过来想，只需要包含例如
     * 0b001100000的数字小于num即可，即数11后面的零的个数，和num作比较
     */
    public int findIntegersOutOfTime(int num) {
        for (int i = 0; i < tag.length; i++)
            tag[i] = 0b11 << i;

        int count = 0;
        for (int i = 0; i <= num; i++) {
            count += match(i) ? 1 : 0;
        }

        return count;
    }

    public int findIntegers(int num) {
        for (int i = 0; i < tag.length; i++)
            tag[i] = 0b11 << i;
        int count = num + 1;
        for (int i = 0; i < tag.length; i++) {
            if (tag[i] < num) {
                count -= Math.pow(2, i);
            }else {
                while(true)
                    // 解法有问题
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonNegativeIntegersWithoutConsecutiveOnes consecutiveOnes = new NonNegativeIntegersWithoutConsecutiveOnes();
        int num = 5;
        System.out.println(consecutiveOnes.findIntegersOutOfTime(num));
        System.out.println(consecutiveOnes.findIntegers(num));
    }
}
