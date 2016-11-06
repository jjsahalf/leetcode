package leetcode;

/**
 * Created by yufeijiang on 11/6/16.
 */
public class MinimumUniqueWordAbbreviationSolution {

    private int minLen;
    private String minStr;

    public MinimumUniqueWordAbbreviationSolution(){
        minLen=Integer.MAX_VALUE;
    }

    public String minAbbreviation(String target, String[] dictionary) {
        if(target==null || target.length()==0){
            return "";
        }
        if(dictionary==null || dictionary.length==0){
            return String.valueOf(target.length());
        }
        dfs(target, new StringBuilder(), 0, 0, 0, dictionary);
        return this.minStr;
    }


    public void dfs(String target, StringBuilder sb, int pos, int currLen, int counter, String[] dictionary){
        int sbOriginSize = sb.length();
        if(currLen>=this.minLen){
            sb.setLength(sbOriginSize);
            return;
        }
        if(pos==target.length()){
            if(counter>0){
                sb.append(counter);
                currLen++;
            }

            if(currLen>=this.minLen){
                sb.setLength(sbOriginSize);
                return;
            }
            boolean isAllInvalid=true;
            for(String dic: dictionary){
                if(validWordAbbreviation(dic, sb.toString())){
                    isAllInvalid=false;
                    break;
                }
            }
            if(isAllInvalid){
                this.minLen=currLen;
                this.minStr=sb.toString();
            }
        }else{
            //abbr this bit
            dfs(target, sb, pos+1, currLen, counter+1, dictionary);

            //do not abbr this bit
            if(counter>0){
                sb.append(counter);
                currLen++;
                counter=0;
            }
            sb.append(target.charAt(pos));
            currLen++;
            dfs(target, sb, pos+1, currLen, 0, dictionary);
        }
        sb.setLength(sbOriginSize);
    }


    public boolean validWordAbbreviation(String wordStr, String abbrStr) {
        char[] word=wordStr.toCharArray();
        char[] abbr=abbrStr.toCharArray();
        int i = 0, j = 0;
        while (i < word.length && j < abbr.length) {
            if (word[i] == abbr[j]) {
                i++; j++;
                continue;
            }
            if (abbr[j] <= '0' || abbr[j] > '9') return false;
            int count = 0;
            while(j < abbr.length && (abbr[j] >= '0' && abbr[j] <= '9')) {
                count = count * 10 + abbr[j] - '0';
                j++;
            }
            i += count;
        }
        return i == word.length && j == abbr.length;
    }

}
