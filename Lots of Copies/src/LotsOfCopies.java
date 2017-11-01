import java.util.Arrays;

//Sarah Huang
//Array Minilab
//Nov 1 2017
import java.util.Arrays;
public class LotsOfCopies {
	public static void main(String[] args) {
		int num=7;
		String strMain="APCS";
		int[] arrMain= {1,2,3,4,5};
		changeMe(num, strMain, arrMain);
		System.out.println(num+" "+strMain+" "+Arrays.toString(arrMain));
		//b is equal to a's initial value
		int a=num;
		int b=a;
		a=9;
		//d is equal to c's initial value
		System.out.println(b);
		String c=strMain;
		String d=c;
		c="APCS2";
		System.out.println(d);
		//array f is changed to the new e
		int[] e= {1,2,3,4,5};
		int [] f= e;
		e[0]=9;
		System.out.println(Arrays.toString(f));
		
	}
	//changing num or String doesn't change in main, but array does
	public static void changeMe(int x, String str, int[] arr) {
		x=9;
		str="APCS2";
		for(int i=0;i<arr.length;i++) {
			arr[i]=2*i;
		}
	}

}
