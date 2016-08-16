package leetcode;

/**
 * Created by yufeijiang on 8/14/16.
 */
public class OneEditDistanceSolution {
    /*
    大同小异,
        public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(m == n) return isOneModified(s, t);
        if(m - n == 1) return isOneDeleted(s, t);
        if(n - m == 1) return isOneDeleted(t, s);
        // 长度差距大于2直接返回false
        return false;
    }

    private boolean isOneModified(String s, String t){
        boolean modified = false;
        // 看是否只修改了一个字符
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(modified) return false;
                modified = true;
            }
        }
        return modified;
    }

    public boolean isOneDeleted(String longer, String shorter){
        // 找到第一组不一样的字符，看后面是否一样
        for(int i = 0; i < shorter.length(); i++){
            if(longer.charAt(i) != shorter.charAt(i)){
                return longer.substring(i + 1).equals(shorter.substring(i));
            }
        }
        return true;
    }
}
     */




    public boolean isOneEditDistance(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        if(s.equals(t)){
            return false;
        }
        if(s.length()==t.length()){
            int counter=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=t.charAt(i)){
                    counter++;
                    if(counter==2){
                        return false;
                    }
                }
            }
            if(counter==1){
                return true;
            }else{
                return false;
            }
        }
        if(Math.abs(s.length()-t.length())>1){
            return false;
        }else{
            if(s.length()==0 || t.length()==0){
                return true;
            }
            if(s.length()>t.length()){
                CharSequence tSequence = new StringBuffer(t);
                if(s.contains(tSequence)){
                    return true;
                }
                int counter=0;
                int sIndex=0;
                for(int i=0;i<t.length();i++){
                    if(t.charAt(i)!=s.charAt(sIndex)){
                        counter++;
                        if(counter==2){
                            return false;
                        }
                        sIndex++;
                        if(t.charAt(i)!=s.charAt(sIndex)){
                            return false;
                        }
                    }
                    sIndex++;
                }
                return true;
            }else{
                //CharSequence sSequence=new StringBuffer(s);
                if(t.contains(s)){
                    return true;
                }
                int counter=0;
                int tIndex=0;
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)!=t.charAt(tIndex)){
                        counter++;
                        if(counter==2){
                            return false;
                        }
                        tIndex++;
                        if(s.charAt(j)!=t.charAt(tIndex)){
                            return false;
                        }
                    }
                    tIndex++;
                }
                return true;
            }
        }
        //return false;
    }
}
