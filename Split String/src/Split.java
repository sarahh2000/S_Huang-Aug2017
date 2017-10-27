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
		System.out.println(getFilling("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
	}
	
	public static String getFilling (String filling) {
		String[] array=filling.split("bread");
		return array[1];
		
	}
}
