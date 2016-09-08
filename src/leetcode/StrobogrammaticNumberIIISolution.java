package leetcode;

/**
 * Created by yufeijiang on 9/8/16.
 */
public class StrobogrammaticNumberIIISolution {
    public int strobogrammaticInRange(String low, String high) {
        char[] mirror={'0','1','6','8','9'};
        char[] single={'0','1','8'};

        int lowLength=low.length();
        int highLength=high.length();
        int sum=0;

        int n=lowLength;
        while(n<=highLength){
            int left=n/2;
            int middle=n%2;
            StringBuilder sb=new StringBuilder();
            sum+=numberGenerator(sb, left,middle, mirror, single, low, high);
            n++;
        }
        return sum;
    }

    public boolean lessThanOrEqualTo(String a, String b){
        if(a.equals(b)){
            return true;
        }
        if(a.length()>b.length()){
            return false;
        }else if(a.length()<b.length()){
            return true;
        }
        int length=a.length();
        int i=0;
        while(i<length){
            if(a.charAt(i)>b.charAt(i)){
                return false;
            }else if(a.charAt(i)<b.charAt(i)){
                return true;
            }
            i++;
        }
        return true;
    }

    public int numberGenerator(StringBuilder sb, int left, int middle, char[] mirror, char[] single, String low, String high){
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
            //System.out.println(str);
            if(lessThanOrEqualTo(low, str) && lessThanOrEqualTo(str, high)){
                return 1;
            }
        }else if(sb.length()==left){
            int counter=0;
            for(int i=0; i<single.length;i++){
                sb.append(single[i]);
                counter+=numberGenerator(sb, left, middle, mirror, single, low, high);
                sb.deleteCharAt(sb.length()-1);
            }
            return counter;
        }else if(sb.length()<left){
            int counter=0;
            for(int i=0;i<mirror.length;i++){
                if(sb.length()==0 && mirror[i]=='0'){
                    continue;
                }
                sb.append(mirror[i]);
                counter+=numberGenerator(sb, left, middle, mirror, single,low,high);
                sb.deleteCharAt(sb.length()-1);
            }
            return counter;
        }
        return 0;
    }
}
