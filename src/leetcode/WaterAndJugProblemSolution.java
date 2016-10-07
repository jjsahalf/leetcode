package leetcode;

/**
 * Created by yufeijiang on 10/6/16.
 */
public class WaterAndJugProblemSolution {
    public boolean canMeasureWater(int x, int y, int z) {
        if((x+y)==z || ( (x+y)>z && z%gcd(x, y)==0 ) ) {
            return true;
        }else{
            return false;
        }
    }
    public int gcd(int x, int y){
        return y==0 ? x : gcd(y, x%y);
    }
}
