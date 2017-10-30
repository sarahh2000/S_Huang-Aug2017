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
		System.out.println(Arrays.toString("I reallyreally likeapples really".split("really")));
		System.out.println(getFilling("breadapplespineapplesbreadlettucetomatobreadbaconmayohambreadcheese"));
		System.out.println(spaceGetFilling("bread apples pineapples bread lettuce tomato bread bacon mayo ham bread cheese"));
	}
	
	//part one
	public static String getFilling (String filling) {
		String insides="";
		String[] array=filling.split("bread");
		for(int i=1;i<array.length-1;i++) {
			insides+=array[i];
		}
		return insides;
	}
	
	//part two
	public static String spaceGetFilling (String filling) {
		String everything="";
		String []array=filling.split(" ");
		for(int i=0;i<array.length;i++) {
			everything+=array[i];
		}
		return getFilling(everything);
	}
}
