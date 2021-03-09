package Easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        if (flowerbed.length == 1)
            return flowerbed[0] == 0 && n <= 1;
        int couldPlaceNum = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            couldPlaceNum++;
            flowerbed[0] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                couldPlaceNum++;
            }
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0)
            couldPlaceNum++;

        return couldPlaceNum >= n;
    }
}
