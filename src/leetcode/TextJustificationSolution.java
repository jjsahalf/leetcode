package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 10/11/16.
 */
public class TextJustificationSolution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList();
        if(words==null || words.length==0){
            return list;
        }
        if(words[0].equals("")){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<maxWidth;i++){
                sb.append(" ");
            }
            list.add(sb.toString());
            return list;
        }
        if(maxWidth==0){
            list.add("");
            return list;
        }
        int minSpace=0;
        int currLineWordCounter=0;
        int currLineWordLength=0;
        List<String> currLineList=new ArrayList();
        for(int i=0; i<words.length; i++){
            if(currLineWordLength+minSpace+words[i].length()<=maxWidth){
                currLineList.add(words[i]);
                minSpace++;
                currLineWordCounter++;
                currLineWordLength+=words[i].length();
            }else{
                StringBuffer sb=new StringBuffer();
                if(currLineWordCounter==1){
                    sb.append(currLineList.get(0));
                    while(sb.length()<maxWidth){
                        sb.append(" ");
                    }
                    list.add(sb.toString());

                    minSpace=0;
                    currLineWordCounter=0;
                    currLineWordLength=0;
                    currLineList=new ArrayList();
                    i--;

                    continue;
                }
                int totalSpaces=maxWidth-currLineWordLength;
                int baseSpaceLength=totalSpaces/(currLineWordCounter-1);
                StringBuffer baseSpaceSb=new StringBuffer();
                for(int k=0; k<baseSpaceLength; k++){
                    baseSpaceSb.append(" ");
                }
                String baseSpaceStr=baseSpaceSb.toString();
                int extraSpace=totalSpaces%(currLineWordCounter-1);
                sb.append(currLineList.get(0));
                for(int j=1; j<currLineList.size();j++){
                    sb.append(baseSpaceStr);
                    if(extraSpace>0){
                        sb.append(" ");
                        extraSpace--;
                    }
                    sb.append(currLineList.get(j));
                }
                list.add(sb.toString());
                minSpace=0;
                currLineWordCounter=0;
                currLineWordLength=0;
                currLineList=new ArrayList();
                i--;
            }
        }
        StringBuffer sb=new StringBuffer();
        sb.append(currLineList.get(0));
        for(int j=1;j<currLineList.size();j++){
            sb.append(" ");
            sb.append(currLineList.get(j));
        }
        while(sb.length()<maxWidth){
            sb.append(" ");
        }
        list.add(sb.toString());
        return list;
    }
}
