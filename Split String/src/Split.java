//Sarah Huang
//Oct 27 2017
//split strings by the thing you tell it to
import java.util.Arrays;
public class Split {
	public static void main(String[] args) {
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
		System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
		System.out.println(Arrays.toString("I reallyreallyreally likeapples".split("really")));
		System.out.println(Arrays.toString("reallyI reallyreally likeapples".split("really")));
		System.out.println(Arrays.toString("I reallyreally likeapples really likeapples".split("really")));
		System.out.println(Arrays.toString("breadcheesehammayobreadcheesebread".split("bread")));
		System.out.println(getFilling("breadapplespineapplesbreadlettucetomatobreadbaconmayohambreadcheese"));
		System.out.println(spaceGetFilling("bread apples pineapples bread lettuce tomato bread bacon mayo ham bread cheese"));
		System.out.println(getFilling("breadcheesehammayocheesebreadcheese"));
	}
	
	//part one
	public static String getFilling (String everything) {
		String insides="";
		String[] array=everything.split("bread");
		String[] array2=everything.split("b");
		if(everything.indexOf("bread")<0||everything.equals("bread")) {
			return "not a sandwich";
		}else if(array2[array2.length-1].equals("read")) {
			for(int i=1;i<array.length;i++) {
				insides+=array[i];
			}
			return insides;
		}else {
			for(int i=1;i<array.length-1;i++) {
				insides+=array[i];
			}
			if(insides.equals("")) {
				return "not a sandwich";
			}else {
				return insides;
			}
		}
	}
	
	//part two
	public static String spaceGetFilling (String everything) {
		String getFillingString="";
		String []array=everything.split(" ");
		for(int i=0;i<array.length;i++) {
			getFillingString+=array[i];
		}
		return getFilling(getFillingString);
	}
}
