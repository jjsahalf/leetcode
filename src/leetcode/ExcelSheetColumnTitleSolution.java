package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 2/2/16.
 */
public class ExcelSheetColumnTitleSolution {

    //THE CODE IN THE COMMENT IS BETTER
    /*
    public String convertToTitle(int n) {
    if(n <= 0){
        throw new IllegalArgumentException("Input is not valid!");
    }

    StringBuilder sb = new StringBuilder();

    while(n > 0){
        n--;
        char ch = (char) (n % 26 + 'A');
        n /= 26;
        sb.append(ch);
    }

    sb.reverse();
    return sb.toString();
}


//SOME LITTLE CHANGE



     */






    public String convertToTitle(int n) {


        String result=new String();

        if(n<=0){
            return result;
        }

        List<Character> list=new ArrayList();



        do{
            int remainder=n%26;
            n/=26;
            char current='A';
            if(remainder==0){
                current='Z';
                n--;
                list.add(current);
                continue;
            }

            for(int j=1;j<remainder;j++){
                current++;
            }

            list.add(current);

        }while(n>0);

        StringBuffer sb=new StringBuffer();
        for(int i=list.size()-1;i>=0; i--){
            sb.append(list.get(i));
        }

        result=sb.toString();
        return result;


    }

}
