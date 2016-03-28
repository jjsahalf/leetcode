package leetcode;

/**
 * Created by yufeijiang on 3/28/16.
 */
public class PermutationSequenceSolution {

    public String getPermutation(int n, int k) {
        String result=new String();
        if(n<=0 || k<=0){
            return result;
        }
        StringBuffer sb=new StringBuffer();
        int facRes=fac(n);
        k--;
        boolean[] visited=new boolean[n];
        int index=n;
        int base=facRes;
        int remainder=k;
        while(index>0){
            base=base/index;
            Integer i=remainder/base;
            remainder=remainder%base;
            Integer j=0;
            int counter=0;
            while(counter<=i){
                if(visited[j]==false){
                    counter++;
                }
                j++;
            }
            visited[j-1]=true;
            sb.append(j.toString());
            index--;
        }
        return sb.toString();
    }


    int fac(int num){
        int res=1;
        while(num>=1){
            res*=num;
            num--;
        }
        return res;
    }


    //暴力破解会超时,不可取
    /*
    public String getPermutation(int n, int k) {
        String result=new String();
        if(n<=0 || k<=0){
            return result;
        }

        StringBuffer sb=new StringBuffer();
        int counter=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        List<String> list=new ArrayList();
        helper(sb, counter, list, visited, n, k);

        return list.get(0);



    }

    public int helper(StringBuffer sb, int counter, List<String> list, boolean[] visited, int n, int k){
        if(sb.length()==n){
            counter++;
            if(counter==k){
                String result=sb.toString();
                list.add(result);
            }
            return counter;
        }else{
            for(int i=0;i<n;i++){
                if(counter==k){
                    return counter;
                }
                if(visited[i]==false){
                    visited[i]=true;
                    Integer content=new Integer(i+1);
                    sb.append(content.toString());
                    counter=helper(sb,counter,list,visited, n, k);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i]=false;
                }
            }
        }
        return counter;
    }*/
}
