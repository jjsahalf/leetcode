package leetcode;

import java.util.List;

/**
 * Created by yufeijiang on 11/2/16.
 */
public class ValidWordSquareSolution {
    public boolean validWordSquare(List<String> words) {
        if(words==null || words.size()==0){
            return false;
        }
        int max=0;
        for(String str:words){
            max=Math.max(max, str.length());
        }
        if(max!=words.size()){
            return false;
        }
        char[][] array=new char[max][max];
        for(int i=0; i<max; i++){
            String curr=words.get(i);
            for(int j=0;j<max;j++){
                if(j<curr.length()){
                    array[i][j]=curr.charAt(j);
                }else{
                    array[i][j]='A';
                }
            }
        }

        for(int i=0;i<max;i++){
            for(int j=0; j<max;j++){
                if(array[i][j]!=array[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
}
