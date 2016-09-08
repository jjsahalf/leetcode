package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yufeijiang on 9/8/16.
 */
public class GroupShiftedStringsSolution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res=new ArrayList();
        if(strings==null || strings.length==0){
            return res;
        }
        List<String> workingList=new LinkedList();
        for(String str:strings){
            workingList.add(str);
        }
        List<String> curr=new ArrayList();
        while(workingList.size()!=0){
            String str=workingList.get(0);
            workingList.remove(str);
            curr=new ArrayList();
            curr.add(str);
            for(int i=0; i<26; i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<str.length();j++){
                    char add=(char)((str.charAt(j)-'a'+i)%26+'a');
                    sb.append(add);
                }
                String shift=sb.toString();
                System.out.println(shift);
                int mover=0;
                while(mover<workingList.size()){
                    String it=workingList.get(mover);
                    if(it.equals(shift)){
                        curr.add(shift);
                        workingList.remove(it);
                    }else{
                        mover++;
                    }
                }
            }
            res.add(curr);
        }
        return res;
    }

}
