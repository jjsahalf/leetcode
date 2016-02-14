package leetcode;

/**
 * Created by yufeijiang on 2/14/16.
 */
public class AddDigitsSolution {
    public int addDigits(int num) {
        return num-9*((num-1)/9);
    }
}
