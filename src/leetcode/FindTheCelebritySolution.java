package leetcode;

/**
 * Created by yufeijiang on 9/12/16.
 */
public class FindTheCelebritySolution {
    public int findCelebrity(int n) {
        if(n<=1){
            return -1;
        }
        int fan=0;
        int celebrity=1;
        while(fan<n && celebrity<n){
            if(knows(fan,celebrity)){
                do{
                    fan++;
                }while(fan==celebrity);
            }else{
                celebrity=fan;
                fan=celebrity+1;
            }
        }
        for(int i=0; i<n;i++){
            if(i!=celebrity){
                if(knows(celebrity,i)){
                    return -1;
                }
                if(!knows(i,celebrity)){
                    return -1;
                }
            }
        }
        return celebrity;
    }
}
