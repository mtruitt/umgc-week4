/**
 * Mark Truitt
 * CMIS 242
 * Week 4 - GUI / Recursion
 *
 */

public class CountdownTimer {
    private final int count;

    public CountdownTimer(int count) {
        this.count = count;
    }

    public void start() {
        System.out.println("Recursion Demo - Countdown Timer");
        System.out.println("Starting countdown...");
        System.out.flush();
        countDown(count);
    }

    private void countDown(int n) {
        if (n == 0) {
            System.out.println("Time's up!");
            System.out.flush();
        } else {
            System.out.println(n + " seconds left");
            System.out.flush();
            countDown(n - 1);
        }
    }
}
