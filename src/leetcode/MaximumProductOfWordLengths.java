package leetcode;

/**
 * Created by yufeijiang on 8/29/16.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if(words==null || words.length<=1){
            return 0;
        }
        int[] elements=new int[words.length];
        for(int i=0;i<words.length;i++){
            String str=words[i];
            for(int j=0; j<str.length(); j++){
                //if(str.equals("")){
                //    elements[i]=0;
                //    continue;
                //}
                elements[i]|=1<<str.charAt(j)-'a';
            }
        }
        int maxProduct=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                int and=elements[i] & elements[j];
                if(and ==0){
                    if(words[i].length()*words[j].length()>maxProduct){
                        maxProduct=words[i].length()*words[j].length();
                    }
                }
            }
        }
        return maxProduct;
    }
}
