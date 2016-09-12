package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 9/12/16.
 */
public class EncodeandDecodeStringsSolution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs==null || strs.size()==0){
            return new String();
        }
        StringBuffer sb=new StringBuffer();
        for(String str:strs){
            sb.append("+");
            for(int i=0;i<str.length();i++){
                sb.append("#");
                sb.append(str.charAt(i));
                sb.append("#");
            }
            sb.append("-");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        System.out.println(s);
        List<String> res=new ArrayList();
        if(s.equals("")){
            return res;
        }
        int mover=0;
        while(mover<s.length()-1){
            //mover=0;
            while(!(s.charAt(mover)=='-' && ((mover+1==s.length()) || s.charAt(mover+1)=='+'))){
                mover++;
            }
            String curr=s.substring(0,mover+1);
            if(curr.equals("+-")){
                res.add("");
            }else{
                curr=curr.substring(1,curr.length()-1);
                StringBuilder sb=new StringBuilder();
                int index=1;
                while(index<curr.length()){
                    sb.append(curr.charAt(index));
                    index+=3;
                }
                String aStr=sb.toString();
                res.add(aStr);
            }
            s=s.substring(mover+1);
            mover=0;
        }
        return res;
    }
}
