package leetcode;

/**
 * Created by yufeijiang on 2/16/16.
 */
public class NimGameSolution {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        if (n == 4) {
            return false;
        }

        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
