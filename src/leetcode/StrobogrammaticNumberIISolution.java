package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/8/16.
 */
public class StrobogrammaticNumberIISolution {
    public List<String> findStrobogrammatic(int n) {
        List<String> list=new ArrayList();
        if(n<=0){
            return list;
        }
        char[] mirror={'0','1','6','8','9'};
        char[] single={'0','1','8'};

        int left=n/2;
        int middle=n%2;
        StringBuilder sb=new StringBuilder();
        numberGenerator(list, sb, left,middle, mirror, single);
        return list;
    }
    public void numberGenerator(List<String> list, StringBuilder sb, int left, int middle, char[] mirror, char[] single){
        if(sb.length()==left+middle){
            StringBuilder temp=new StringBuilder(sb.toString());
            for(int i=left-1;i>=0;i--){
                char afterMiddle=temp.charAt(i);
                if(afterMiddle=='6'){
                    temp.append('9');
                }else if(afterMiddle=='9'){
                    temp.append('6');
                }else{
                    temp.append(afterMiddle);
                }
            }
            String str=temp.toString();
            list.add(str);
            return;
        }else if(sb.length()==left){
            for(int i=0; i<single.length;i++){
                sb.append(single[i]);
                numberGenerator(list, sb, left, middle, mirror, single);
                sb.deleteCharAt(sb.length()-1);
            }
        }else if(sb.length()<left){
            for(int i=0;i<mirror.length;i++){
                if(sb.length()==0 && mirror[i]=='0'){
                    continue;
                }
                sb.append(mirror[i]);
                numberGenerator(list, sb, left, middle, mirror, single);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
