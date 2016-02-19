package leetcode;

/**
 * Created by yufeijiang on 2/19/16.
 */
public class LongestPalindromicSubstring {



    /*
    主要是要考虑两种palidorme
    有一个中心的,和没有一个中心的,
    一个helper, 两种情况, 通过传入的index来控制.
    遍历反复调用helper即可,配合一点小优化.

     */

    private String longest;
    private int longestHalfLength;

    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        //String res=new String();
        if(s.length()==0){
            return null;
        }

        longest=new String();
        int longestHalfLength=0;
        int i=0;

        while(i<s.length()-longestHalfLength){
            helper(i,i,s);
            helper(i,i+1,s);
            i++;
        }

        return this.longest;
    }


    public void helper(int leftCenter, int rightCenter, String s){
        int goLeft=leftCenter;
        int goRight=rightCenter;

        while(goLeft>=0 && goRight<s.length()){
            if(s.charAt(goLeft)==s.charAt(goRight)){
                goLeft--;
                goRight++;
            }else{
                break;
            }
        }
        goRight--;
        goLeft++;
        int currentLength=goRight-goLeft+1;
        if(currentLength>longest.length()){
            longest=s.substring(goLeft,goRight+1);
        }

        this.longestHalfLength=longest.length()/2-1;

    }

}
