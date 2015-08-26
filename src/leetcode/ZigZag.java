package leetcode;

/**
 * Created by yufeijiang on 8/25/15.
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if(s==null){
            return null;
        }

        if(s.equals("")){
            return "";
        }

        if(numRows==0){
            return null;
        }
        if(numRows==1){
            return s;
        }

        if(s.length()==1){
            return s;
        }
        int groupNumber=numRows+numRows-2;
        int unitNumColumns=numRows-2+1;
        int length=s.length();
        int mod=length%groupNumber;
        int numColumns=0;
        if(mod==0){
            numColumns=length/groupNumber*unitNumColumns;
        }
        if(mod>0 && mod <=numRows){
            numColumns=length/groupNumber*unitNumColumns+1;
        }
        if(mod>numRows && mod < groupNumber){
            numColumns=length/groupNumber*unitNumColumns+1+mod-numRows;
        }
        char [][] fillInMatrix=new char[numRows][numColumns];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numColumns;j++){
                fillInMatrix[i][j]='\0';
            }
        }
        char charIt='\0';
        int x=0;
        int y=0;
        int direction=-1;

        for(int i=0; i<s.length();i++){
            charIt=s.charAt(i);
            fillInMatrix[y][x]=charIt;
            if(direction==-1){
                if(y==numRows-1){
                    direction=1;
                    y--;
                    x++;
                }else{
                    y++;
                }
            }else if(direction==1){
                if(y==0){
                    direction=-1;
                    y++;
                }else{
                    y--;
                    x++;
                }
            }
        }


        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numColumns;j++){
                if(fillInMatrix[i][j]!='\0'){
                    sb.append(fillInMatrix[i][j]);
                }
            }
        }
        return sb.toString();

    }
}
