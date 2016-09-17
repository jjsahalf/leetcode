package leetcode;

/**
 * Created by yufeijiang on 9/16/16.
 */
public class LexicographicalNumbersSolution {
    /* 这个解法过不了!
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res =new ArrayList();
        if(n<=0){
            return res;
        }
        List<String> list=new ArrayList();
        for(int i=1;i<=n;i++){
            Integer integer=new Integer(i);
            list.add(integer.toString());
        }
        Collections.sort(list, new Comparator<String>(){
            public int compare(String a, String b){
                if(a==null && b==null){
                    return -1;
                }
                if(a==null && b!=null){
                    return -1;
                }
                if(a!=null && b==null){
                    return 1;
                }
                if(a.equals(b)){
                    return -1;
                }
                int length=Math.min(a.length(), b.length());
                for(int i=0;i<length;i++){
                    if(a.charAt(i)!=b.charAt(i)){
                        return a.charAt(i)-b.charAt(i);
                    }
                }
                if(a.length()==length){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        for(String s:list){
            res.add(Integer.parseInt(s));
        }
        return res;
    }*/

}
