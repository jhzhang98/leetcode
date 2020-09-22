package Medium;

import java.util.Arrays;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flightBookings = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0] - 1; i < booking[1]; i++) {
                flightBookings[i] += booking[2];
            }
        }
        return flightBookings;
    }

    public static void main(String[] args) {
        CorporateFlightBookings corporate = new CorporateFlightBookings();
        int[][] bookings = {{1, 1, 10}, {2, 3, 20} , {2, 5, 25}};
        int n = 5;
        System.out.println(Arrays.toString(corporate.corpFlightBookings(bookings, n)));
    }
}
