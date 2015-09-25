package leetcode;

/**
 * Created by yufeijiang on 9/24/15.
 */
public class CountAndSay {
    public String countAndSaySolution(int n) {
        if(n<=0){
            return null;
        }


        if(n==1){
            return "1";
        }
        String beginning="1";
        String input="";
        String output="";
        input=beginning;
        for(int i=0;i<n-1;i++){
            output=scan(input);
            input=output;
        }

        return output;
    }

    public String scan(String str){

        StringBuffer say=new StringBuffer();
        Integer counter=0;
        int start=0;
        int end=0;
        String counterStr="";
        String unit="";
        Character startChar=new Character(' ');
        while(end<str.length()){
            startChar=str.charAt(start);
            if(startChar==str.charAt(end)){
                counter++;
                end++;
            }else{
                counterStr=counter.toString();
                unit=counterStr+startChar.toString();
                say.append(unit);
                start=end;
                counter=0;
            }
        }
        counterStr=counter.toString();
        unit=counterStr+startChar.toString();
        say.append(unit);

        return say.toString();

    }

}
