package Easy;

public class CountOfMatchesInTournament {
    int total = 0;

    private void add(int n) {
        if (n == 1)
            return;
        total += n / 2;
        if (n % 2 == 0) {
            add(n / 2);
        } else {
            add(n / 2 + 1);
        }
    }

    public int numberOfMatches(int n) {
        add(n);
        return total;
    }

    public static void main(String[] args) {
        CountOfMatchesInTournament matchesInTournament = new CountOfMatchesInTournament();
        int n = 7;
        System.out.println(matchesInTournament.numberOfMatches(n));
    }
}
