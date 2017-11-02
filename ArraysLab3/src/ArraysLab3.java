//Sarah Huang
//Nov1
//ArraysLab3]
import java.util.Arrays;
public class ArraysLab3 {
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] result= new int [arr1.length];
		for(int i=0;i<arr1.length;i++) {
			result[i]=arr1[i]+arr2[2];
		}
		return result;
	}
	public static int[] append(int[] arr, int num) {
		int[] result= new int[arr.length+1];
		for(int i=0; i<arr.length;i++) {
			result[i]=arr[i];
		}
		result[result.length-1]=num;
		return result;
	}
	public static int[] remove(int[] arr, int idx) {
		int[] result= new int [arr.length-1];
		for(int i=0;i<idx;i++) {
			result[i]=arr[i];
		}
		for(int i=idx+1;i<arr.length;i++) {
			result[i-1]=arr[i];
		}
		return result;
	}
	public static int sumEven(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i+=2) {
			sum+=arr[i];
		}
		return sum;
	}
	public static void rotateRight(int[] arr) {
		int temp=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=temp;
	}
	public static void main (String[] args) {
		int [] arr1= {5, 10, 15, 20, 25, 30, 35, 40};
		int [] arr2= {7,14, 21, 28, 35, 42, 49, 56};
	}
}
