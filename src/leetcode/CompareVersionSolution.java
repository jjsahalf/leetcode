package leetcode;

public class CompareVersionSolution {
	

    public int compareVersion(String version1, String version2) {

    	String[] version1_array=version1.split("\\.");
    	String[] version2_array=version2.split("\\.");
    	
    	int length=0;
    	String[] version1_align_array;
    	String[] version2_align_array;
    	if(version1_array.length>=version2_array.length){
    		length=version1_array.length;
    		version1_align_array=version1_array;
    		version2_align_array=new String[length];
    		for(int i=0; i<version2_align_array.length;i++){
    			version2_align_array[i]="0";
    		}
    		for(int j=0;j<version2_array.length;j++){
    			version2_align_array[j]=version2_array[j];
    		}
    	}else{
    		length=version2_array.length;
    		version1_align_array=new String[length];
    		version2_align_array=version2_array;
    		for(int i=0; i<version1_align_array.length;i++){
    			version1_align_array[i]="0";
    		}
    		for(int j=0;j<version1_array.length;j++){
    			version1_align_array[j]=version1_array[j];
    		}
    	}
    	
    	for(int index=0;index<version1_align_array.length;index++){
    		if(Integer.parseInt(version1_align_array[index])>
    		Integer.parseInt(version2_align_array[index])){
    			return 1;
    		}
    		
    		if(Integer.parseInt(version1_align_array[index])<
    				Integer.parseInt(version2_align_array[index])){
    			return -1;
    		}
    		
    	}
    	
    	return 0;
    	

    }
}
