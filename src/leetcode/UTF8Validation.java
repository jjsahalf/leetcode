package leetcode;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        if(data==null || data.length==0){
            return true;
        }
        int i=0;
        while(i<data.length){
            int curr=data[i];
            int mask=1;
            mask=mask<<7;
            int counter=0;
            while( (mask & curr) !=0){
                mask=mask>>1;
                counter++;
            }
            //System.out.println(counter);
            if(counter==0){
                i++;
                continue;
            }else{
                if(counter==1){
                    return false;
                }
                if(counter==8){
                    return false;
                }
                i++;
                counter--;
                while(counter>=1){
                    if(i>=data.length){
                        return false;
                    }
                    curr=data[i];
                    curr=curr>>6;
                    if( (curr & 3) ==2 ){
                        i++;
                        counter--;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
