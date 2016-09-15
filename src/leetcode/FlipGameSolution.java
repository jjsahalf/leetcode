package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/14/16.
 */
public class FlipGameSolution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list=new ArrayList();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+' && s.charAt(i-1)=='+'){
                StringBuffer sb=new StringBuffer();
                sb.append(s.substring(0,i-1));
                sb.append("--");
                if(i+1<s.length()){
                    sb.append(s.substring(i+1));
                }
                list.add(sb.toString());
            }
        }
        return list;
    }
}
