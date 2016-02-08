package leetcode;

/**
 * Created by yufeijiang on 2/8/16.
 */
public class CountPrimesSolution {
    public int countPrimes(int n) {
        int number=n-1;
        if(number<2){
            return 0;
        }
        if(number==2){
            return 1;
        }

        boolean[] primeArray=new boolean[number];
        for(int i=0;i<primeArray.length;i++){
            primeArray[i]=true;
        }

        double squareRoot=Math.sqrt(number);
        for(int i=2;i<=squareRoot;i++){
            for(int j=i*i;j<=number;j+=i){
                primeArray[j-1]=false;
            }
        }

        int counter=0;
        for(int i=1;i<number;i++){
            if(primeArray[i]){
                counter++;
            }
        }

        return counter;


    }
}
