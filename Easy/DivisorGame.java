package Easy;

public class DivisorGame {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        DivisorGame game = new DivisorGame();
        System.out.println(game.divisorGame(100));
    }
}
