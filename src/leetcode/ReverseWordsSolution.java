package leetcode;

public class ReverseWordsSolution {
	private String[] split_strings;
	//handles null, "","       "
    public String reverseWords(String s) {
    	if(s==null || s.equals("")){
    		return "";
    	}
    	
    	split_strings=null;
    	split_strings=s.split(" ");
    	
    	//this one actually is not necessary
    	if(split_strings.length==0){
    		return "";
    	}
    	
    	
    	int length=split_strings.length;
    	StringBuffer sb=new StringBuffer();
    	
    	for(int i=length-1;i>=0;i--){
    		//element in array could be ""
    		//be careful
    		if (!split_strings[i].equals("")) {
				sb.append(split_strings[i]);
				sb.append(" ");
			}
    	}
    	//remove the very last space
    	sb.deleteCharAt(sb.length()-1);
    	String res_string=sb.toString();
    	
    	
        return res_string;
    }

}
