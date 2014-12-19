package leetcode;

public class ReverseWordsTest {

	public static void main(String[] args) {
		String[] string_array=null;
		ReverseWordsSolution instance=new ReverseWordsSolution();
		System.out.println("result is "+instance.reverseWords(" 1"));
		String s="1 ";
		string_array=s.split(" ");
		if(string_array==null){
			System.out.println("null");
		}
		System.out.println(string_array.length);
		

	}

}
