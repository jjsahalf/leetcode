package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 6/22/16.
 */
public class RestoreIPAddressesSolution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList();
        if(s==null || s.equals("") || s.length()>12 || s.length()<4){
            return list;
        }

        int[] pos=new int[s.length()-1];
        for(int i=0; i<pos.length; i++){
            pos[i]=0;
        }

        dfs(list, 0, 3, s, pos);

        return list;
    }

    public void dfs(List<String> list, int index, int quota, String s, int[] pos){
        if(quota==0){
            if(isValidIP(pos, s)){
                list.add(generateIP(pos,s));
            }
            return;
        }

        for(int i=index; i<pos.length;i++){
            pos[i]=1;
            dfs(list, i+1, quota-1, s, pos);
            pos[i]=0;
        }

    }


    public boolean isValidIP(int[] pos, String s ){
        String ip=generateIP(pos, s);
        String[] ipSeg=ip.split("\\.");
        if(ipSeg.length!=4){
            return false;
        }
        for(String str:ipSeg){
            if(str.length()>1 && str.charAt(0)=='0'){
                return false;
            }
            int current = Integer.parseInt(str);
            if(current<0 || current>255 ){
                return false;
            }
        }

        return true;
    }

    public String generateIP(int[] pos, String s){
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<s.length();i++){
            sb.append(s.charAt(i));
            if(i<pos.length){
                if(pos[i]==1){
                    sb.append(".");
                }
            }
        }
        return sb.toString();
    }

}
